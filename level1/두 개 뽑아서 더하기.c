#include stdio.h
#include stdbool.h
#include stdlib.h

void init(int answer, int answer_size);
int number_of_case(int numbers_len);
void select_sort(int answer, int answer_size);
void sum(int answer,int answer_size,int numbers,int numbers_len);
void del_duplication(int answer,int answer_size);
    
static int count = 0;

 numbers_len은 배열 numbers의 길이입니다.
int solution(int numbers[], size_t numbers_len) {
  
     경우의 수
    int answer_size= number_of_case(numbers_len);
    int answer = (int)malloc(sizeof(int)answer_size);
    init(answer,answer_size);
    
     선택 정렬
    select_sort(numbers,numbers_len);
    
     두 수 더하기
    sum(answer,answer_size,numbers,numbers_len);

     중복 제거한 메모리 반환
    realloc(answer,sizeof(int)(answer_size-count));
    
     선택 정렬
    select_sort(answer,answer_size);
    
    return answer;
}

int number_of_case(int numbers_len)
{
    int num1=1;
    int num2=2;
    for(int i = 1 ; i = numbers_len;i++)
    {
        num1=i;
    }
    if(numbers_len  2)
    {
         for(int i = 1; i=(numbers_len-2);i++)
         {
             num2=i;         
         }
    }
       
    if(num20)
    {
        return num1num2;

    }
    else
    {
        return num12;
    }
}


void init(int answer, int answer_size)
{
    for(int i = 0 ; i  answer_size; i++)
    {
        answer[i] = 201;
    }
}

void select_sort(int answer, int answer_size)
{
    int min = 0;
     선택 정렬
    for(int i = 0 ; i  answer_size;i++)
    {
        min = answer[i];
        for(int j = i ; janswer_size;j++)
        {
            if(min = answer[j])
            {
                min = answer[j];
                answer[j] = answer[i];
                answer[i] = min;
            }
        }
    }
}


void sum(int answer,int answer_size,int numbers,int numbers_len)
{
    int i = 0;
    for(int j = 0; j  numbers_len; j++)
        {
            for(int k = j+1; k  numbers_len ; k++)
            {
                answer[i] = numbers[j] + numbers[k];
                 중복 제거
                del_duplication(answer,answer_size);
                
                i++;
            }
        }
}

void del_duplication(int answer,int answer_size)
{
    for(int i = 0; i  answer_size; i++)
    {
        for(int j = i+1 ;j  answer_size; j++)
        {
            if(answer[i]==answer[j])
            {
                answer[i] = 201;
                count++;
            }
        }
    }
}
