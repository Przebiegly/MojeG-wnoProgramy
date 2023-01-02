using System;
using System.Numerics;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace Praktyki
{
    class Program
    {

        static void BasicMath(string temp1, string temp2, string ope)
        {
            int num1 = 0;
            num1 = Convert.ToInt32(temp1);
            int num2 = 0;
            num2 = Convert.ToInt32(temp2); ;

            double result = 0;

            switch (ope)
            {
                case "+":
                    result = num1 + num2; break;
                case "-":
                    result = num1 - num2; break;
                case "/":
                    result = num1 / num2; break;
                case "%":
                    result = num1 % num2; break;
                case "*":
                    result = num1 * num2; break;    
                case "^":
                    result = Math.Pow(num1, num2); break;      


            }
            Console.WriteLine(result);
        }

        static void ValueChecker(string phrase)
        {
            string[] Ope = {"+","-","/","%","*","^","=" };
            string temp1 = "";
            string Operator = "";
            string temp2 = "";
            int i = 0;

            for(int ii = i; ii<phrase.Length; ii++)
            {
                string temptemp = Convert.ToString(phrase[ii]);
                bool isExist = Array.Exists(Ope, element => element == temptemp);
                if (isExist)
                {
                    Operator += phrase[ii];
                    i = ii + 1;
                    ii = phrase.Length + 1;


                } else if (Char.IsWhiteSpace(phrase, ii))
                {
                    Operator += phrase[ii + 1];
                    i = ii + 3;
                    ii = phrase.Length + 1;
                }
                else
                {
                    temp1 += phrase[ii];
                }

            }
            for (int ii = i; ii < phrase.Length; ii++)
            {
                temp2 += phrase[ii];
            }

            BasicMath(temp1, temp2, Operator);

        }
        public static void Main(string[] args)
        {

            string phrease;
            bool end = false;

            while (!end)
            {

                Console.Write("> ");
                phrease = Console.ReadLine();
                if(phrease.Equals("quit") || phrease.Equals("exit"))
                {
                    end = true;
                    continue;
                }

                ValueChecker(phrease);

            }

        }

    }

}
