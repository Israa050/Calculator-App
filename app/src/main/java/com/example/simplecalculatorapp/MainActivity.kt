package com.example.simplecalculatorapp

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.simplecalculatorapp.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.text.DecimalFormat
import javax.xml.xpath.XPathExpression

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(R.layout.activity_main)

        setContentView(binding.root)

        //Clear All
        binding.buttonClearAll.setOnClickListener {
            binding.input.text = ""
            binding.output.text = ""
            binding.input.text = "0"
        }

        //Delete last element
        binding.buttonClear.setOnClickListener {
            val removeLast = binding.input.text.toString().dropLast(1)
            binding.input.text = removeLast
        }


        binding.buttonZero.setOnClickListener {
            binding.input.text = addToInput("0")
        }

        binding.button1.setOnClickListener {
            binding.input.text = addToInput("1")
        }

        binding.button2.setOnClickListener {
            binding.input.text = addToInput("2")
        }

        binding.button3.setOnClickListener {
            binding.input.text = addToInput("3")
        }

        binding.button4.setOnClickListener {
            binding.input.text = addToInput("4")
        }

        binding.button5.setOnClickListener {
            binding.input.text = addToInput("5")
        }

        binding.button6.setOnClickListener {
            binding.input.text = addToInput("6")
        }

        binding.button7.setOnClickListener {
            binding.input.text = addToInput("7")
        }

        binding.button8.setOnClickListener {
            binding.input.text = addToInput("8")
        }

        binding.button9.setOnClickListener {
            binding.input.text = addToInput("9")
        }

        binding.buttonAdd.setOnClickListener {
            binding.input.text = addToInput("+")
        }

        binding.buttonDot.setOnClickListener {
            binding.input.text = addToInput(".")
        }

        binding.buttonMultiplication.setOnClickListener {
            binding.input.text = addToInput("x")
            binding.input.text = getInputExpression()
        }

        binding.buttonSubtraction.setOnClickListener {
            binding.input.text = addToInput("-")
        }

        binding.buttonDivision.setOnClickListener {
            binding.input.text = addToInput("/")
        }

        binding.buttonEqual.setOnClickListener {
            onEqual()
        }

    }

    private fun addToInput(text :String):String{
        return binding.input.text.toString() + "" + text
    }


    private fun getInputExpression():String{
        var expression = binding.input.text.replace(Regex ("x"), replacement = "*")

        return expression
    }

    private fun onEqual(){

       try {
            var expression = binding.input.text.toString()
            var  result = ExpressionBuilder(expression).build()
            val value = result.evaluate()

           binding.output.text = DecimalFormat("0.#####").format(value).toString()

        }catch (e:Exception){
          //throw error
          binding.output.text = "error"
        }
    }


}