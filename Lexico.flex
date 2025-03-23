package app;
import java_cup.runtime.*;
import java.util.*;

%%

%cup
%public
%class Lexico
%line
%column
%char

%{
    private ArrayList<String> lista = new ArrayList<>();
    private ArrayList<SymbolTableEntry> tsEntries = new ArrayList<>();
    
    public ArrayList getList() {
        return this.lista;
    }

    public ArrayList<SymbolTableEntry> getTS(){
        return this.tsEntries;
    }

    public void vaciarLista() {
        this.lista.clear();
    }

    public void agregarATablaDeSimbolos(String token, String valor) {
        boolean existe = false;
        for (SymbolTableEntry entrada : tsEntries) {
            if (entrada.getToken().equals(token) && ((entrada.getNombre().equals(valor)) || (entrada.getNombre().equals("_" + valor)))) {
                existe = true;
            }
        }

        if (!existe) tsEntries.add(new SymbolTableEntry(valor, token));
    }
%}


LETRA = [a-zA-Z]
DIGITO = [0-9]
ESPACIO = [ \t\f\n\r\n]+
OP_SUMA = "+"
OP_RESTA = "-"
OP_DIV = "/"
OP_MULT = "*"
OP_MOD = "%"
OP_POT = "^"
OP_MAY_IG = ">="
OP_MEN_IG = "<="
OP_DIST = "<>"
OP_MEN = "<"
OP_MAY = ">"
OP_IG = "=="
OP_ASIGN = "="
OP_AND = "&"
OP_OR = "||"
OP_NOT = "!"
PAREN_OPEN = "("
PAREN_CLOSE = ")"
BLOCK_BEG = "{"
BLOCK_END = "}"
BRACK_OPEN = "["
BRACK_CLOSE = "]"
PUNTO_COMA = ";"
COMA = ","
PUNTO = "."
DOS_PUNTOS = ":"
WRITE = "WRITE"|"write"|"Write"
CONST_INT = {DIGITO}+
CONST_DOU = ({DIGITO}* "." {DIGITO}+) | ({DIGITO}+ "." {DIGITO}*)
CONST_STR = "'" ({DIGITO}|{LETRA}|{ESPACIO})* "'"     // Agregar la posibildad de cualquier elemento y espacios
CONST_BIN = "(" ("0"|"1")+  ","  "2"  ")"
CONST_HEX = "(" ({DIGITO} | "A" | "B" | "C" | "D" | "E" | "F")+  ","  "16" ")"
INTEGER = "INTEGER"|"integer"|"Integer"
STRING = "STRING"|"string"|"String"
FLOAT = "FLOAT"|"float"|"Float"
COMMENT = "/*" ~ "*/" // El simbolo ~ incluye cualquier caracter
INLINE_COMMENT = "</" ~ "/>" // El simbolo ~ incluye cualquier caracter
WHILE = "WHILE"|"while"|"While"
IF = "IF"|"if"|"If"
ELSE = "ELSE"|"else"|"Else"
DEFINE = "DEFINE" | "define"
DEFINE_END = "ENDDEFINE"|"enddefine"
PROGRAM_BEGIN = "PROGRAM"|"program"
PROGRAM_END = "END"|"end"
MIDDLE = "MIDDLE"|"Middle"|"middle"
ID = {LETRA} ({LETRA} | {DIGITO} | _ ({LETRA}|{DIGITO}))*


%%

<YYINITIAL> {


{OP_IG} {
    lista.add("Token OP_IG, encontrado Lexema "+ yytext());
    System.out.println("Token OP_IG, encontrado Lexema "+ yytext());
    return new Symbol(sym.OP_IG, yycolumn + 1, yyline + 1, yytext());
} 
{OP_ASIGN} {
    System.out.println("Token OP_ASIGN encontrado, Lexema: "+ yytext());
    lista.add("Token OP_ASIGN, encontrado Lexema "+ yytext());
    return new Symbol(sym.OP_ASIGN, yycolumn + 1, yyline + 1, yytext());
}
{OP_SUMA} {
    System.out.println("Token OP_SUMA encontrado, Lexema "+ yytext());
    lista.add("Token OP_SUMA, encontrado Lexema "+ yytext());
    return new Symbol(sym.OP_SUMA, yycolumn + 1, yyline + 1, yytext());
}
{OP_RESTA} {
    System.out.println("Token OP_RESTA encontrado, Lexema "+ yytext());
    lista.add("Token OP_RESTA, encontrado Lexema "+ yytext());
    return new Symbol(sym.OP_RESTA, yycolumn + 1, yyline + 1, yytext());
}
{OP_DIV} {
    System.out.println("Token OP_DIV encontrado, Lexema "+ yytext());
    lista.add("Token OP_DIV, encontrado Lexema "+ yytext());
    return new Symbol(sym.OP_DIV, yycolumn + 1, yyline + 1, yytext());
}
{OP_MULT} {
    System.out.println("Token OP_MULT encontrado, Lexema "+ yytext());
    lista.add("Token OP_MULT, encontrado Lexema "+ yytext());
    return new Symbol(sym.OP_MULT, yycolumn + 1, yyline + 1, yytext());
}
{OP_MOD} {
    System.out.println("Token OP_MOD encontrado, Lexema "+ yytext());
    lista.add("Token OP_MOD, encontrado Lexema "+ yytext());
    return new Symbol(sym.OP_MOD, yycolumn + 1, yyline + 1, yytext());
}
{OP_POT} {
    System.out.println("Token OP_POT encontrado, Lexema "+ yytext());
    lista.add("Token OP_POT, encontrado Lexema "+ yytext());
    return new Symbol(sym.OP_POT, yycolumn + 1, yyline + 1, yytext());
}
{OP_MAY_IG} {
    System.out.println("Token OP_MAY_IG encontrado, Lexema "+ yytext());
    lista.add("Token OP_MAY_IG, encontrado Lexema "+ yytext());
    return new Symbol(sym.OP_MAY_IG, yycolumn + 1, yyline + 1, yytext());
}
{OP_MEN_IG} {
    System.out.println("Token OP_MEN_IG encontrado, Lexema "+ yytext());
    lista.add("Token OP_MEN_IG, encontrado Lexema "+ yytext());
    return new Symbol(sym.OP_MEN_IG, yycolumn + 1, yyline + 1, yytext());
}
{OP_MEN} {
    System.out.println("Token OP_MEN encontrado, Lexema "+ yytext());
    lista.add("Token OP_MEN, encontrado Lexema "+ yytext());
    return new Symbol(sym.OP_MEN, yycolumn + 1, yyline + 1, yytext());
}
{OP_MAY} {
    System.out.println("Token OP_MAY encontrado, Lexema "+ yytext());
    lista.add("Token OP_MAY, encontrado Lexema "+ yytext());
    return new Symbol(sym.OP_MAY, yycolumn + 1, yyline + 1, yytext());
}
{OP_DIST} {
    System.out.println("Token OP_DIST, Lexema "+ yytext());
    lista.add("Token OP_DIST, encontrado Lexema "+ yytext());
    return new Symbol(sym.OP_DIST, yycolumn + 1, yyline + 1, yytext());
} 
{OP_AND} {
    System.out.println("Token OP_AND, encontrado Lexema "+ yytext());
    lista.add("Token OP_AND, encontrado Lexema "+ yytext());
    return new Symbol(sym.OP_AND, yycolumn + 1, yyline + 1, yytext());
} 
{OP_OR} {
    System.out.println("Token OP_OR, encontrado Lexema "+ yytext());
    lista.add("Token OP_OR, encontrado Lexema "+ yytext());
    return new Symbol(sym.OP_OR, yycolumn + 1, yyline + 1, yytext()); 
}
{OP_NOT} {
    System.out.println("Token OP_NOT, encontrado Lexema "+ yytext());
    lista.add("Token OP_NOT, encontrado Lexema "+ yytext());
    return new Symbol(sym.OP_NOT, yycolumn + 1, yyline + 1, yytext()); 
} 
{PAREN_OPEN} {
    System.out.println("Token PAREN_OPEN, encontrado Lexema "+ yytext());
    lista.add("Token PAREN_OPEN, encontrado Lexema "+ yytext());
    return new Symbol(sym.PAREN_OPEN, yycolumn + 1, yyline + 1, yytext()); 
}
{PAREN_CLOSE} {
    System.out.println("Token PAREN_CLOSE, encontrado Lexema "+ yytext());
    lista.add("Token PAREN_CLOSE, encontrado Lexema "+ yytext()); 
    return new Symbol(sym.PAREN_CLOSE, yycolumn + 1, yyline + 1, yytext()); 
}
{BLOCK_BEG} {
    System.out.println("Token BLOCK_BEG, encontrado Lexema "+ yytext());
    lista.add("Token BLOCK_BEG, encontrado Lexema "+ yytext());
    return new Symbol(sym.BLOCK_BEG, yycolumn + 1, yyline + 1, yytext()); 
}
{BLOCK_END} {
    System.out.println("Token BLOCK_END, encontrado Lexema "+ yytext());
    lista.add("Token BLOCK_END, encontrado Lexema "+ yytext());
    return new Symbol(sym.BLOCK_END, yycolumn + 1, yyline + 1, yytext()); 
}
{BRACK_OPEN} {
    System.out.println("Token BRACK_OPEN, encontrado Lexema "+ yytext());
    lista.add("Token BRACK_OPEN, encontrado Lexema "+ yytext());
    return new Symbol(sym.BRACK_OPEN, yycolumn + 1, yyline + 1, yytext()); 
}
{BRACK_CLOSE} {
    System.out.println("Token BRACK_CLOSE, encontrado Lexema "+ yytext());
    lista.add("Token BRACK_CLOSE, encontrado Lexema "+ yytext());
    return new Symbol(sym.BRACK_CLOSE, yycolumn + 1, yyline + 1, yytext()); 
}
{PUNTO_COMA} {
    System.out.println("Token PUNTO_COMA, encontrado Lexema "+ yytext());
    lista.add("Token PUNTO_COMA, encontrado Lexema "+ yytext());
    return new Symbol(sym.PUNTO_COMA, yycolumn + 1, yyline + 1, yytext()); 
}
{COMA} {
    System.out.println("Token COMA, encontrado Lexema "+ yytext());
    lista.add("Token COMA, encontrado Lexema "+ yytext());
    return new Symbol(sym.COMA, yycolumn + 1, yyline + 1, yytext()); 
}
{PUNTO} {
    System.out.println("Token PUNTO, encontrado Lexema "+ yytext());
    lista.add("Token PUNTO, encontrado Lexema "+ yytext());
    return new Symbol(sym.PUNTO, yycolumn + 1, yyline + 1, yytext()); 
}
{DOS_PUNTOS} {
    System.out.println("Token DOS_PUNTOS, encontrado Lexema "+ yytext());
    lista.add("Token DOS_PUNTOS, encontrado Lexema "+ yytext());
    return new Symbol(sym.DOS_PUNTOS, yycolumn + 1, yyline + 1, yytext()); 
}
{WRITE} {
    System.out.println("Token WRITE, encontrado Lexema "+ yytext());
    lista.add("Token WRITE, encontrado Lexema "+ yytext());
    return new Symbol(sym.WRITE, yycolumn + 1, yyline + 1, yytext()); 
}
{CONST_INT}	          {
    System.out.println("Token CONST_INT, encontrado Lexema "+ yytext()); 
    /* Verificación de rango de constante entera */
    if((Integer.parseInt(yytext()) >= 0) && (Integer.parseInt(yytext()) <= 65535)){
        agregarATablaDeSimbolos("CONST_INT", yytext());
        lista.add("Token CONST_INT, encontrado Lexema "+ yytext());
        return new Symbol(sym.CONST_INT, yycolumn + 1, yyline + 1, yytext()); 
    } else {
        throw new Exception(
            "Constante entera fuera de rango: <" + yytext() + "> en la linea: " + (yyline + 1) + " columna: " + (yycolumn + 1)
        );
    }
} /* recordar que no debe exceder los 16 bits -32768 < entero < 32767 */
{CONST_DOU} {
    System.out.println("Token CONST_DOU, encontrado Lexema "+ yytext()); 
    /* Verificación de rango de constante real */
    if((Double.parseDouble(yytext()) >= 0) && (Double.parseDouble(yytext()) <= 4294967295.0)){
        agregarATablaDeSimbolos("CONST_DOU", yytext());
        lista.add("Token CONST_DOU, encontrado Lexema "+ yytext());
        return new Symbol(sym.CONST_DOU, yycolumn + 1, yyline + 1, yytext()); 
    } else {
        throw new Exception(
            "Constante real fuera de rango: <" + yytext() + "> en la linea: " + (yyline + 1) + " columna: " + (yycolumn + 1)
        );
    }
} /* recordar que no debe exceder los 32 bits -2147483648 < x < 2147483647*/
{CONST_STR} {
    System.out.println("Token CONST_STR, encontrado Lexema "+ yytext()); 
    /* Verificación de longitud de cadena de texto */
    if(yytext().length() <= 30){
        agregarATablaDeSimbolos("CONST_STR", yytext());
        lista.add("Token CONST_STR, encontrado Lexema "+ yytext()); 
        return new Symbol(sym.CONST_STR, yycolumn + 1, yyline + 1, yytext()); 
    } else {
        throw new Exception(
            "Constante string fuera de rango: <" + yytext() + "> en la linea: " + (yyline + 1) + " columna: " + (yycolumn + 1)
        );
    }
}
{CONST_BIN} {
    System.out.println("Token CONST_BIN, encontrado Lexema "+ yytext()); 
    agregarATablaDeSimbolos("CONST_BIN", yytext());
    lista.add("Token CONST_BIN, encontrado Lexema "+ yytext());
    return new Symbol(sym.CONST_BIN, yycolumn + 1, yyline + 1, yytext()); 
}
{CONST_HEX} {
    System.out.println("Token CONST_HEX, encontrado Lexema "+ yytext()); 
    agregarATablaDeSimbolos("CONST_HEX", yytext());
    lista.add("Token CONST_HEX, encontrado Lexema "+ yytext());
    return new Symbol(sym.CONST_HEX, yycolumn + 1, yyline + 1, yytext()); 
}
{INTEGER}  {
    System.out.println("Token INTEGER, encontrado Lexema "+ yytext()); 
    lista.add("Token INTEGER, encontrado Lexema "+ yytext());
    return new Symbol(sym.INTEGER, yycolumn + 1, yyline + 1, yytext()); 
}
{STRING} {
    System.out.println("Token STRING, encontrado Lexema "+ yytext());
    lista.add("Token STRING, encontrado Lexema "+ yytext()); 
    return new Symbol(sym.STRING, yycolumn + 1, yyline + 1, yytext()); 
}
{FLOAT} {
    System.out.println("Token FLOAT, encontrado Lexema "+ yytext()); 
    lista.add("Token FLOAT, encontrado Lexema "+ yytext());
    return new Symbol(sym.FLOAT, yycolumn + 1, yyline + 1, yytext()); 
}
{WHILE} {
    System.out.println("Token WHILE, encontrado Lexema "+ yytext());
    lista.add("Token WHILE, encontrado Lexema "+ yytext()); 
    return new Symbol(sym.WHILE, yycolumn + 1, yyline + 1, yytext()); 
}
{IF} {
    System.out.println("Token IF, encontrado Lexema "+ yytext());
    lista.add("Token IF, encontrado Lexema "+ yytext()); 
    return new Symbol(sym.IF, yycolumn + 1, yyline + 1, yytext()); 
}
{ELSE} {
    System.out.println("Token ELSE, encontrado Lexema "+ yytext());
    lista.add("Token ELSE, encontrado Lexema "+ yytext()); 
    return new Symbol(sym.ELSE, yycolumn + 1, yyline + 1, yytext()); 
}
{DEFINE}  {
    System.out.println("Token DEFINE, encontrado Lexema "+ yytext());
    lista.add("Token DEFINE, encontrado Lexema "+ yytext()); 
    return new Symbol(sym.DEFINE, yycolumn + 1, yyline + 1, yytext()); 
}
{DEFINE_END} {
    System.out.println("Token DEFINE_END, encontrado Lexema "+ yytext());
    lista.add("Token DEFINE_END, encontrado Lexema "+ yytext()); 
    return new Symbol(sym.DEFINE_END, yycolumn + 1, yyline + 1, yytext()); 
}
{PROGRAM_BEGIN} {
    System.out.println("Token PROGRAM_BEGIN, encontrado Lexema "+ yytext());
    lista.add("Token PROGRAM_BEGIN, encontrado Lexema "+ yytext());
    return new Symbol(sym.PROGRAM_BEGIN, yycolumn + 1, yyline + 1, yytext()); 
}
{PROGRAM_END} {
    System.out.println("Token PROGRAM_END, encontrado Lexema "+ yytext());
    lista.add("Token PROGRAM_END, encontrado Lexema "+ yytext());
    return new Symbol(sym.PROGRAM_END, yycolumn + 1, yyline + 1, yytext()); 
}
{MIDDLE}  {
    System.out.println("Token MIDDLE, encontrado Lexema "+ yytext());
    lista.add("Token MIDDLE, encontrado Lexema "+ yytext());
    return new Symbol(sym.MIDDLE, yycolumn + 1, yyline + 1, yytext()); 
}
{ID} {
    lista.add("Token ID, encontrado Lexema "+ yytext());
    System.out.println("Token ID, encontrado Lexema "+ yytext()); 
    agregarATablaDeSimbolos("ID", yytext());
    return new Symbol(sym.ID, yycolumn + 1, yyline + 1, yytext()); 
}
{ESPACIO}		      {/* no se realiza accion por lo tanto se ignoran*/}
{COMMENT}	          {/* no se realiza accion por lo tanto se ignoran*/}
{INLINE_COMMENT}	  {/* no se realiza accion por lo tanto se ignoran*/}

}

[^]		{ throw new Exception("Caracter no permitido: <" + yytext() + "> en la linea: " + (yyline + 1) + " columna: " + (yycolumn + 1)); }


















