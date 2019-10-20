package com.example.calculadora



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_cero.setOnClickListener { appendOnExpresstion("0", true) }
        bt_uno.setOnClickListener { appendOnExpresstion("1", true) }
        bt_dos.setOnClickListener { appendOnExpresstion("2", true) }
        bt_tres.setOnClickListener { appendOnExpresstion("3", true) }
        bt_cuatro.setOnClickListener { appendOnExpresstion("4", true) }
        bt_cinco.setOnClickListener { appendOnExpresstion("5", true) }
        bt_seis.setOnClickListener { appendOnExpresstion("6", true) }
        bt_siete.setOnClickListener { appendOnExpresstion("7", true) }
        bt_ocho.setOnClickListener { appendOnExpresstion("8", true) }
        bt_nueve.setOnClickListener { appendOnExpresstion("9",true) }

        bt_dividir.setOnClickListener { appendOnExpresstion("/",false) }
        bt_sumar.setOnClickListener { appendOnExpresstion("+",false) }
        bt_resta.setOnClickListener { appendOnExpresstion("-",false) }
        bt_multiplicar.setOnClickListener { appendOnExpresstion("*",false) }
        bt_parent_l.setOnClickListener { appendOnExpresstion("(",false) }
        bt_parent_r.setOnClickListener { appendOnExpresstion(")",false) }
        bt_punto.setOnClickListener { appendOnExpresstion(".",false) }

        bt_clear.setOnClickListener {
            tv_resultado.text=""
            tv_display.text=""
        }

        bt_cleaone.setOnClickListener {
            val string = tv_display.text.toString()
            if(string.isNotEmpty()){
                tv_display.text=string.substring(0,string.length-1)
            }
            else
                tv_resultado.text=""
        }
        bt_igual.setOnClickListener {
            try {
                val display = ExpressionBuilder(tv_display.text.toString()).build()
                val result = display.evaluate()
                val longResult = result.toLong()
                tv_resultado.text="="
                if (result == longResult.toDouble())

                    tv_resultado.text = longResult.toString()
                 else
                    tv_resultado.text = result.toString()
                }catch(e:Exception){


                  Log.d("Exception","mensaje:"+e.message)
                     }
            }

        }


    fun appendOnExpresstion(string:String, canClear:Boolean){
        if(canClear){
            tv_display.append(string)
        }else{
            tv_display.append(tv_resultado.text)
            tv_display.append(string)
            tv_resultado.text=""
        }
    }
}
