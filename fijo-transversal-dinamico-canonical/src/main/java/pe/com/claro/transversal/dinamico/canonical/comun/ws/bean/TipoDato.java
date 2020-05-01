package pe.com.claro.transversal.dinamico.canonical.comun.ws.bean;

import org.hibernate.dialect.OracleTypesHelper;

public class TipoDato {
    public final static int FLOAT           =   6;
    public final static int NUMERIC         =   2;
    public final static int CHAR            =   1;
    public final static int VARCHAR         =  12;
    public final static int DATE            =  91;
    public final static int TIME            =  92;
    public final static int TIMESTAMP       =  93;
    public final static int NULL            =   0;
    public final static int ARRAY               = 2003;
    public final static int BLOB                = 2004;
    public final static int CLOB                = 2005;
    public final static int REF                 = 2006;
public final static int BOOLEAN = 16;
public static final int REF_CURSOR_JDBC = 2012;
public static final int TIMESTAMP_WITH_TIMEZONE = 2014;

public static final int REF_CURSOR_ORACLE = 100000;


}
