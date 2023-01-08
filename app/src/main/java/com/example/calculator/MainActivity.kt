package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {

    private var lastname: Boolean = false
    private var last: Boolean = false

    var indicator =0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input: TextView = findViewById(R.id.input)
        val output: TextView = findViewById(R.id.output)

        val one: Button = findViewById(R.id.one)
        val two: Button = findViewById(R.id.two)
        val three: Button = findViewById(R.id.three)
        val four: Button = findViewById(R.id.four)
        val five: Button = findViewById(R.id.five)
        val six: Button = findViewById(R.id.six)
        val seven: Button = findViewById(R.id.seven)
        val eight: Button = findViewById(R.id.eight)
        val nine: Button = findViewById(R.id.nine)
        val zero: Button = findViewById(R.id.zero)
        val doublezero: Button = findViewById(R.id.doublezero)
        val clear: Button = findViewById(R.id.AC)
        val bracket1: Button = findViewById(R.id.bracket1)
        val bracket2: Button = findViewById(R.id.bracket2)
        val dot: Button = findViewById(R.id.dot)

        val add: Button = findViewById(R.id.plus)
        val sub: Button = findViewById(R.id.minus)
        val div: Button = findViewById(R.id.division)
        val mul: Button = findViewById(R.id.multiply)
        val equal: Button = findViewById(R.id.equal)




        one.setOnClickListener{
            input.append("1")
            lastname = true
            last= false
        }
        two.setOnClickListener{
            input.append("2")
            lastname = true
            last= false
        }
        three.setOnClickListener{
            input.append("3")
            lastname = true
            last= false
        }
        four.setOnClickListener{
            input.append("4")
            lastname = true
            last= false
        }
        five.setOnClickListener{
            input.append("5")
            lastname = true
            last= false
        }
        six.setOnClickListener{
            input.append("6")
            lastname = true
            last= false
        }
        seven.setOnClickListener{
            input.append("7")
            lastname = true
            last= false
        }
        eight.setOnClickListener{
            input.append("8")
            lastname = true
            last= false
        }
        nine.setOnClickListener{
            input.append("9")
            lastname = true
            last= false
        }
        add.setOnClickListener{
            if(lastname || input.text.endsWith(")")) {
                input.append("+")
            }
            if(last){
                input.append("0+")
            }
            lastname= false
            last = false
            indicator=0
        }
        sub.setOnClickListener{
            if(lastname || input.text.isEmpty() || input.text.endsWith(")")){
                input.append("-")}
            if(last){
                input.append("0-")
            }
            lastname = false
            last = false
            indicator=0
        }
        div.setOnClickListener{
            if(lastname || input.text.endsWith(")")){
            input.append("/")}
            if(last){
                input.append("0/")
            }
            lastname = false
            last = false
            indicator=0
        }
        mul.setOnClickListener{
            if(lastname || input.text.endsWith(")")){
                input.append("*")}
            if(last){
                input.append("0*")
            }
            lastname = false
            last = false
            indicator=0
        }
        bracket1.setOnClickListener{
            input.append("(")
            lastname= false
            last = false
        }
        bracket2.setOnClickListener{
            input.append(")")
            lastname=false
            last=false

        }
        doublezero.setOnClickListener{
            input.append("00")
            lastname = true
            last= false
        }
        zero.setOnClickListener{
            input.append("0")
            lastname = true
            last= false
        }
        clear.setOnClickListener{
            input.text = ""
            output.text=""
            lastname = false
            last = false
            indicator=0
        }
        dot.setOnClickListener{
            if(indicator==0){
           if(input.text.isEmpty()||input.text.endsWith("-")||input.text.endsWith("+")||input.text.endsWith("/")||input.text.endsWith("*")||input.text.endsWith(")")||input.text.endsWith("(")){
            input.append("0.")}
           if(lastname){
               input.append(".")}
            lastname=false
            last=true
            indicator=1}
        }

        equal.setOnClickListener{

            if(input.text.isEmpty()){
                Toast.makeText(this,"Enter Number",Toast.LENGTH_LONG).show()
                lastname = false
                last = false
            }
            else if(input.text.filter { it=='(' }.count() != input.text.filter { it==')' }.count()){
                output.text = "Expression Error"
            }
            else{if(lastname || input.text.endsWith(")")|| input.text.endsWith(".")||input.text.endsWith("-")||input.text.endsWith("+")||input.text.endsWith("/")||input.text.endsWith("*")){
                lastname = true
                last = false
                try {
                    val expression = ExpressionBuilder(input.text.toString()).build()
                    val result = expression.evaluate()
                   

                   output.text = result.toString()
                }catch(e:Exception){
                    output.text ="Syntax Error"
                }
            }
            }
        }






   }
}

