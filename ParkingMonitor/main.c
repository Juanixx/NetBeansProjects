/* 
 * File:   main.c
 * Author: JuanEduardo
 *
 * Created on 1 de julio de 2015, 17:44
 */



#include <stdlib.h>
#include <windows.h>
#include <stdio.h>


char serialPort[22];
char arduinoID[11];
char szBuff[99];
HANDLE hSerial;



HANDLE abrir_puerto(char serialPort[])
{

    hSerial = CreateFile(serialPort, GENERIC_READ | GENERIC_WRITE,
						  0, 0, OPEN_EXISTING, FILE_ATTRIBUTE_NORMAL,0);

    if(hSerial!=INVALID_HANDLE_VALUE)
 	{
 		DCB dcbSerialParams = {0};
 		DCB dcbSerial = {0};

 		dcbSerial.DCBlength=sizeof(dcbSerialParams);
 		if (!GetCommState(hSerial, &dcbSerialParams))
 			printf("\nGetCommState error!");
 		else
    		printf("\nGetCommState ok.");

 		dcbSerialParams.BaudRate=CBR_9600;
 		dcbSerialParams.ByteSize=8;
 		dcbSerialParams.StopBits=ONESTOPBIT;
 		dcbSerialParams.Parity=NOPARITY;

 		if(!SetCommState(hSerial, &dcbSerialParams))
 			printf("\nSetCommState error!");
 		else
 			printf("\nSetCommState ok.");

 		COMMTIMEOUTS timeouts={0};
 		timeouts.ReadIntervalTimeout=50;
 		timeouts.ReadTotalTimeoutConstant=50;
 		timeouts.ReadTotalTimeoutMultiplier=10;
		timeouts.WriteTotalTimeoutConstant=50;
 		timeouts.WriteTotalTimeoutMultiplier=10;
 		if(!SetCommTimeouts(hSerial, &timeouts))
 			printf("\nSetCommTimeouts error!");
 		else
  			printf("\nSetCommTimeouts ok.");
    }
    return hSerial;
}


int buscar_puerto()
{
	int x;
	DWORD dwBytesRead;

	char serialPort[11];
	for(x = 0;x < 11;x++)
    {
	 	sprintf(serialPort, "COM%d", x);
	    printf("\nAbriendo %s...", serialPort);

 	    if(abrir_puerto(serialPort) !=INVALID_HANDLE_VALUE)
 	    {
		   printf("\nAbierto puerto %s", serialPort);
		   strcpy(szBuff, arduinoID);
		   WriteFile(hSerial, szBuff, strlen(szBuff), &dwBytesRead, NULL);
		   strcpy(szBuff, "");
		   dwBytesRead = 0;
		   ReadFile(hSerial, szBuff, 95, &dwBytesRead, NULL);
		   szBuff[dwBytesRead] = '\0';
		   if(strncmp(szBuff, "ok", 2) == 0)
		   {
			   printf(" donde está conectado ARDUINO1");
 	          break;
		   }
 	       else
 	       {
			  CloseHandle(hSerial);
		   }
	    }
    }
    if(hSerial !=INVALID_HANDLE_VALUE) return 1;
    else return 0;
}


void probar(char mensaje[])
{
	sprintf(szBuff, "%s\n" , mensaje);
	DWORD dwBytesRead = 0;

	if(!WriteFile(hSerial, szBuff, strlen(szBuff), &dwBytesRead, NULL))
	   	printf("\nWriteFile error!");
	/*else
    	printf("\nWriteFile: %s", szBuff);*/

    strcpy(szBuff, "");
    dwBytesRead = 0;
    if(!ReadFile(hSerial, szBuff, 95, &dwBytesRead, NULL))
	    printf("\nReadFile error!");

    szBuff[dwBytesRead] = '\0';
    if(strlen(szBuff))
    	printf(/* " ReadFile: %s\n",*/ szBuff);

}





main()
{
	char texto[99]="12 ARDUINO1";
	strcpy(arduinoID, "ARDUINO1\n");

	// verificar cuál es el puerto que usa Arduino,
	// y sustituir "COM3" si es diferente
	if(buscar_puerto())
    {
		for(;;)
		{
		    /*printf("\nIntroducir texto a enviar:");
		    fgets(texto, 98, stdin);
		    if(texto[0] == '\n') break;*/
    	    probar(texto);
	    }

        CloseHandle(hSerial);
	}
	else printf("\nNo hay puerto con ARDUINO1\n");
}
















