; Código ensamblador generado

.MODEL LARGE
.386
.STACK 200h

.DATA
_a dd ?
_95 dd 95.00
_100 dd 100.00
_2 dd 2.00
_SI db ' SI$',0
_NO db ' NO$',0
_1 dd 1.00

.CODE
START:
    MOV AX, @DATA
    MOV DS, AX

    FLD _95
    FSTP _a
Etiq28:
    FLD _a
    FLD _100
    FXCH
    FCOM
    FSTSW AX
    SAHF
    FSTP ST(0)
    JNB Etiq29
    FLD _a
    FLD _2
    FXCH
    FCOM
    FSTSW AX
    SAHF
    FSTP ST(0)
    JNB Etiq31
    mov dx, OFFSET _SI
    mov ah, 9
    int 21h
    JMP Etiq30
Etiq31:
    mov dx, OFFSET _NO
    mov ah, 9
    int 21h
Etiq30:
    FLD _a

    FLD _1

    FADD
    FSTP _a
    JMP Etiq28
Etiq29:


    MOV AX, 4C00h
    INT 21h
END START
