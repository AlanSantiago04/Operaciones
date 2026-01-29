package mx.edu.itesca.operaciones

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //Instanciar Objetos
        val lado1 = findViewById<EditText>(R.id.etnumero1)
        val lado2 = findViewById<EditText>(R.id.etnumero2)
        val lado3 = findViewById<EditText>(R.id.etnumero3)
        val tipo = findViewById<TextView>(R.id.tvtipo)
        val verificar = findViewById<Button>(R.id.btncalcular)
        //Programar el evento Click de Button
        verificar.setOnClickListener {
            val A = lado1.text.toString().toDoubleOrNull()
            val B = lado2.text.toString().toDoubleOrNull()
            val C = lado3.text.toString().toDoubleOrNull()
            //Validar Vacio o Null
            if(A == null || B == null || C == null){
                tipo.text = "Ingrese Valores Validos, Por favor"
                return@setOnClickListener
            } else{
                //Llamar funcion
                tipo.text = validacion(A,B,C)
                return@setOnClickListener
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

//Crear Funciones
fun validacion(ladoA: Double, ladoB: Double, ladoC: Double):String{
    if(ladoA <= 0 || ladoB <= 0 || ladoC <= 0){
        return "Uno de los lados es cero"
    } else {
        if (ladoA + ladoB >= ladoC && ladoA + ladoC >= ladoB && ladoB
            + ladoC >= ladoA) {
            if (ladoA == ladoB && ladoB == ladoC) {
                return "Es un Equilatero"
            } else if (ladoA == ladoB || ladoA == ladoC || ladoB == ladoC) {
                return "Es un Isoseles"
            } else {
                return "Es un Escaleno"
            }
        } else {
            return "No forma un triángulo"
        }
    }
}