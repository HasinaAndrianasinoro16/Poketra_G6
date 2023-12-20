package Bdd;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

public class ObjectBdd {

//recupere la sequence pour les id
    public String getSequence (Connection c) throws Exception{
        String sequence = null;
        String name="SEQ"+this.getClass().getSimpleName();
        PreparedStatement pstm= c.prepareStatement("select nextval('"+name+"')");
        ResultSet res = pstm.executeQuery();
        while(res.next()){
            sequence= res.getString(1);
        }
        return sequence;
    }
    
 //recuperer la consonnes pou l'id
    public  String recupererConsonnes(String chaine) {
        String voyelles = "aeiouAEIOU";
        StringBuilder consonnesChaine = new StringBuilder();

        for (int i = 0; i < chaine.length(); i++) {
            char caractere = chaine.charAt(i);

            if (voyelles.indexOf(caractere) == -1) {
                consonnesChaine.append(caractere);
            }
        }

        return consonnesChaine.toString();
    }
    
// IdSequence
    public String idSequence(Connection c) throws Exception{
        String name = this.getClass().getSimpleName();
        String id = "";
        
        if(this.getSequence(c).length() >= 2 ){
            id = this.recupererConsonnes(name)+"0"+this.getSequence(c);
        }else{
            id = this.recupererConsonnes(name)+"00"+this.getSequence(c);
        }
        
        return id;
    }
//fonction select * from tab
    public Vector<String> select (Connection c) throws Exception{
        Vector<String> liste = new Vector<>();
        Field[] f= this.getClass().getDeclaredFields();
        String name=this.getClass().getSimpleName();
        String sql = "select * from "+name;
        System.out.println(sql);
        PreparedStatement stat = c.prepareStatement(sql);
        ResultSet res = stat.executeQuery();
        while(res.next()){
            for(int i=1; i<f.length;i++)
            {
                liste.add(res.getString(i));
            }
        }
        return liste;
    }

//recupere le nom des tab pour avoir insert into tab (nomdecolone1,nomdecolone2, ...) values ...
    public Vector<String> getNamecolumns(Connection c) throws Exception,SQLException
    {
        Vector<String> vstring = new Vector<String>();
        Field[] f = this.getClass().getDeclaredFields();
        String name = this.getClass().getSimpleName();
        PreparedStatement ps = c.prepareStatement("SELECT * FROM "+name);
        ResultSet res = ps.executeQuery();
        ResultSetMetaData meta = res.getMetaData();
        for(int i = 0; i < meta.getColumnCount(); i++)
        {
            if(f[i].getName().compareToIgnoreCase(meta.getColumnName(i+1)) == 0)
            {
                vstring.add(f[i].getName());
            }
        }
        return vstring;
    }

// fonction qui trasforme une vector<string> en string et dans notre cas ici le vector qui contient les noms des colones en string
    public StringBuilder columns(Vector<String>v)
    {
        StringBuilder sb = new StringBuilder();
        //Field[] f= this.getClass().getDeclaredFields();
        sb.append("(");
        for(int i = 0; i < v.size(); i++){
            if(i == v.size()-1)
            {
                sb.append(v.elementAt(i));
                sb.append(")");
            }else{
                sb.append(v.elementAt(i));
                sb.append(",");
            }
        }
        return sb;
    }

//fonction qui permet d'inserer des valeurs dans une table
    public void insert (Connection c) throws Exception,SQLException
    {
        String sql;
        Field[] f=this.getClass().getDeclaredFields();
        String name= this.getClass().getSimpleName();
        PreparedStatement ps = c.prepareStatement("SELECT * FROM "+name);
        ResultSet res = ps.executeQuery();
        ResultSetMetaData meta= res.getMetaData();
        String cmdes="insert into "+name+columns(getNamecolumns(c));
        int size= meta.getColumnCount();
        StringBuilder sb = new StringBuilder();
        sb.append("values(");
        for(int i=0;i<size;i++)
        {
            Object o = this.getClass().getDeclaredMethod("get".concat(f[i].getName())).invoke(this);
            if(f[i].getType().getCanonicalName().compareToIgnoreCase("java.lang.String")==0 || f[i].getType().getCanonicalName().compareToIgnoreCase("java.time.LocalDate") == 0)
            {
                sb.append("\'"+o.toString()+"\'");

            }else{
                sb.append(o.toString());
            }
            if(i!=size-1)
            {
                sb.append(",");
            }
        }
        sb.append(")");
        sql=cmdes+sb.toString();
        PreparedStatement stat = c.prepareStatement(sql);
        System.out.println(sql);
        stat.executeUpdate();
    }
    
    //fonction update set 
    public void update(Connection c, String setcol, String setval, String refcol, String refval) throws Exception {
        String name = this.getClass().getSimpleName();
        String sql = null;
        Field[] f = this.getClass().getDeclaredFields();
        Object colset = null;
        String typecolset = null;
        Object colref = null;
        String typecolref = null;
    
        for (int i = 0; i < f.length; i++) {
            if (f[i].getName().equalsIgnoreCase(setcol)) {
                colset = f[i].getName();
                typecolset = f[i].getType().getSimpleName();
            }
            if (f[i].getName().equalsIgnoreCase(refcol)) {
                colref = f[i].getName();
                typecolref = f[i].getType().getSimpleName();
            }
        }
    
        if (typecolset != null && typecolset.equalsIgnoreCase("String") || typecolset.equalsIgnoreCase("Date")) {
            sql = "UPDATE " + name + " SET " + colset + " = '" + setval + "' WHERE " + colref + " = " + refval;
        }
        if (typecolref != null && (typecolref.equalsIgnoreCase("String") || typecolref.equalsIgnoreCase("Date"))) {
            sql = "UPDATE " + name + " SET " + colset + " = " + setval + " WHERE " + colref + " = '" + refval + "'";
        }
        if (typecolref != null && typecolset != null &&
                (typecolref.equalsIgnoreCase("String") && typecolset.equalsIgnoreCase("String")) ||
                (typecolref.equalsIgnoreCase("Date") && typecolset.equalsIgnoreCase("Date"))) {
            sql = "UPDATE " + name + " SET " + colset + " = '" + setval + "' WHERE " + colref + " = '" + refval + "'";
        }
        if (sql == null) {
            throw new IllegalArgumentException("Invalid column types");
        }
    
        System.out.println(sql);
        PreparedStatement stat = c.prepareStatement(sql);
        stat.executeUpdate();
    }

//select avec condition
    public Vector<String> selectCond (Connection c , String condition)throws Exception{
        Vector<String> liste = new Vector<>();
        String name = this.getClass().getSimpleName();
        String sql = null;
        if(condition == null || condition == " "){
            sql = "select * from "+name;
        }else{
            sql = "select "+condition+" from "+name;
        }
        PreparedStatement stat = c.prepareStatement(sql);
        ResultSet res = stat.executeQuery();
        while(res.next()){
            liste.add(res.getString(condition));
        }
        System.out.println(sql);
        return liste;
    }
}