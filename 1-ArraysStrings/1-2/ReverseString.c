#include<stdio.h>
#include<string.h>

/* Takes n/2 steps, with minimum space added. Time complexity O(n), space O(1) 
 * Also, this method can take care of the problem of the null character in the end
 */
void reverse1(char* s){
	int len = strlen(s);
	int i;
	for(i=0; i<len/2; i++){
		char temp = s[i];
		s[i] = s[len-i-1];
		s[len-i-1] = temp;
	}
}

/* method from CCI book */
void reverse2(char* str){
	char* end = str;
	if(str)
		while(*end) 
			++end; // find the end
	--end; //backup one character b/c the last one is null
	
	while(str < end){
		char temp = *str;
		*str++ = *end;
		*end-- = temp;		
	}
}

int main(){
	char s[] = "TestString123\0";
	reverse1(s);
	printf("%s\n", s);
	char s2[] = "MyTestgnik789\0";
	reverse2(s2);
	printf("%s\n", s2);
}
