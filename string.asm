; Gavin Grant
;1601042
;Oshane Brown
;1600869

.MODEL SMALL ; DECLARE STACK
.STACK 100H

.DATA   ;DELCARING INITIALIZED DATA

        MSG_1 DB  0DH,0AH, " PLEASE ENTER STRING :  $"  ; DECLARE VARIABLE WITH THE PROMPT
        MSG_2 DB  0DH,0AH, " YOUR STRING CONVERTED TO UPPERCASE IS: $"
        MSG_3 DB  0DH,0AH, " YOUR STRING IN REVERSE ORDER: $"
        NL    DB  0DH,0AH, "$"
        STR1 DB  255 DUP(?)
               
.CODE

BEGIN:
          MOV AX,@DATA  ;/moving data entered into the AX registry
          MOV DS,AX

          LEA DX,MSG_1  ;/load address of variables/
          MOV AH,09H
          INT 21H

          LEA SI,STR1
          MOV AH,01H

READ:
          INT 21H
          MOV BL,AL

          CMP AL,0DH
          JE  DOTHIS
          JE  OUTPUT
        

          XOR AL,20H
          MOV [SI],AL
          INC SI
          
          JMP READ
         
TERMINATE:      
        MOV AL,"$"     ; /function to Reverse the string search for a null value/
        MOV [SI],AL

        MOV AH,09H
        LEA DX,NL
        INT 21H

        MOV CX,LENGTH MSG_1
        ADD CX,1
DOTHIS:     ;/function to Reverse the string search for a null value/
        DEC SI  
        MOV AL,[SI]

        MOV [DI],AL
        INC DI
        LOOP DOTHIS
          
        
OUTPUT: ;/displaying results/

          MOV AL,"$"
          MOV [SI],AL
          

          LEA DX,MSG_2
          MOV AH,09H
          INT 21H
          
          ;MOV AH,09H
          ;LEA DX,MSG_3
          ;INT 21H

          LEA DX,STR1
          MOV AH,09H
          INT 21H
          
          LEA DX,MSG_3
          MOV AH,09H
          INT 21H
          
          MOV AH,09H
          LEA DX,NL
          INT 21H
          
          
          MOV AH,4CH
          INT 21H
         
END BEGIN