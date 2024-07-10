package com.example.buscarobjetos

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Juego : AppCompatActivity() {

    //<editor-fold desc="Objetos en pantalla">
    private lateinit var gallinaHuevos: ImageView
    private lateinit var gallinaSaco: ImageView
    private lateinit var gallinaFrente: ImageView
    private lateinit var gallinaHoja: ImageView
    private lateinit var gallinaSaluda: ImageView
    private lateinit var gallo: ImageView
    private lateinit var pala: ImageView
    private lateinit var paja: ImageView
    private lateinit var regadera: ImageView
    private lateinit var regaderaRoja: ImageView
    private lateinit var regaderaVacia: ImageView
    private lateinit var rastrillo: ImageView
    private lateinit var polloTecho: ImageView
    private lateinit var polloGranero: ImageView
    private lateinit var polloFrente: ImageView
    private lateinit var polloTronco: ImageView
    private lateinit var polloEscondido: ImageView
    private lateinit var polloEspanta: ImageView
    private lateinit var sacos: ImageView
    private lateinit var tronco: ImageView
    //</editor-fold>

    //<editor-fold desc="Objetos en mesa a encontrar">
    private lateinit var gallinaHuevosCopia: ImageView
    private lateinit var gallinaSacoCopia: ImageView
    private lateinit var gallinaFrenteCopia: ImageView
    private lateinit var gallinaHojaCopia: ImageView
    private lateinit var gallinaSaludaCopia: ImageView
    private lateinit var galloCopia: ImageView
    private lateinit var palaCopia: ImageView
    private lateinit var pajaCopia: ImageView
    private lateinit var regaderaCopia: ImageView
    private lateinit var regaderaRojaCopia: ImageView
    private lateinit var regaderaVaciaCopia: ImageView
    private lateinit var rastrilloCopia: ImageView
    private lateinit var polloTechoCopia: ImageView
    private lateinit var polloGraneroCopia: ImageView
    private lateinit var polloFrenteCopia: ImageView
    private lateinit var polloTroncoCopia: ImageView
    private lateinit var polloEscondidoCopia: ImageView
    private lateinit var polloEspantaCopia: ImageView
    private lateinit var sacosCopia: ImageView
    private lateinit var troncoCopia: ImageView
    //</editor-fold>

    //<editor-fold desc="Contador">
    private var counter = 0
    private var minutos = 0
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    private lateinit var tv_tiempo: TextView
    private lateinit var tv: TextView
    //</editor-fold>

    private lateinit var mas: ImageView

    private lateinit var tv_tiempo2: TextView
    private lateinit var tv2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)

        iniciar()

        handler = Handler(Looper.getMainLooper())
        startCounter()
    }

    override fun onDestroy() {
        super.onDestroy()
        stopCounter()
    }

    private fun startCounter() {
        runnable = object : Runnable {
            override fun run() {
                if (counter == 60){
                    minutos++
                    counter = 0
                    tv_tiempo?.setText("" + minutos + ":0" + counter + "")
                } else {
                    if (counter < 10){
                        tv_tiempo?.setText("" + minutos + ":0" + counter + "")
                        counter++
                    } else {
                        tv_tiempo?.setText("" + minutos + ":" + counter + "")
                        counter++
                    }
                }

                // Establece el tiempo de espera en milisegundos antes de la próxima actualización
                val delayMillis = 1000
                handler.postDelayed(this, delayMillis.toLong())
            }
        }

        // Inicia el contador
        handler.post(runnable)
    }

    private fun stopCounter() {
        // Detén el contador cuando la actividad se destruya para evitar pérdida de recursos
        handler.removeCallbacks(runnable)
    }

    private fun iniciar() {

        //<editor-fold desc="Iniciar variables de pantalla">
        gallinaHuevos = findViewById(R.id.gallinaHuevos)
        gallinaSaco = findViewById(R.id.gallinaSaco)
        gallinaFrente = findViewById(R.id.gallinaFrente)
        gallinaHoja = findViewById(R.id.gallinaHoja)
        gallinaSaluda = findViewById(R.id.gallinaSaluda)
        gallo = findViewById(R.id.gallo)
        pala = findViewById(R.id.pala)
        paja = findViewById(R.id.paja)
        regadera = findViewById(R.id.regadera)
        regaderaRoja = findViewById(R.id.regaderaRoja)
        regaderaVacia = findViewById(R.id.regaderaVacia)
        rastrillo = findViewById(R.id.rastrillo)
        polloTecho = findViewById(R.id.polloTecho)
        polloGranero = findViewById(R.id.polloGranero)
        polloFrente = findViewById(R.id.polloFrente)
        polloTronco = findViewById(R.id.polloTronco)
        polloEscondido = findViewById(R.id.polloEscondido)
        polloEspanta = findViewById(R.id.polloEspanta)
        sacos = findViewById(R.id.sacos)
        tronco = findViewById(R.id.tronco)
        //</editor-fold>

        //<editor-fold desc="Iniciar variables de mesa">
        gallinaHuevosCopia = findViewById(R.id.gallinaHuevosCopia)
        gallinaSacoCopia = findViewById(R.id.gallinaSacoCopia)
        gallinaFrenteCopia = findViewById(R.id.gallinaFrenteCopia)
        galloCopia = findViewById(R.id.galloCopia)
        palaCopia = findViewById(R.id.palaCopia)
        pajaCopia = findViewById(R.id.pajaCopia)
        regaderaCopia = findViewById(R.id.regaderaCopia)
        regaderaRojaCopia = findViewById(R.id.regaderaRojaCopia)
        regaderaVaciaCopia = findViewById(R.id.regaderaVaciaCopia)
        rastrilloCopia = findViewById(R.id.rastrilloCopia)
        polloFrenteCopia = findViewById(R.id.polloFrenteCopia)
        polloEscondidoCopia = findViewById(R.id.polloEscondidoCopia)
        //</editor-fold>

        //Variable de contador
        tv_tiempo=findViewById(R.id.tv_tiempo)
        tv_tiempo2=findViewById(R.id.tv_tiempo2)
        tv=findViewById(R.id.tv)
        tv2=findViewById(R.id.tv2)

        mas=findViewById(R.id.x)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        // Obtenemos las coordenadas del toque
        val x = event.x
        val y = event.y

        //<editor-fold desc="COORDENADAS DE OBJETOS">
        val gallinaHuevosX = gallinaHuevos.x
        val gallinaHuevosY = gallinaHuevos.y

        val gallinaSacoX = gallinaSaco.x
        val gallinaSacoY = gallinaSaco.y

        val gallinaFrenteX = gallinaFrente.x
        val gallinaFrenteY = gallinaFrente.y

        val gallinaHojaX = gallinaHoja.x
        val gallinaHojaY = gallinaHoja.y

        val gallinaSaludaX = gallinaSaluda.x
        val gallinaSaludaY = gallinaSaluda.y

        val galloX = gallo.x
        val galloY = gallo.y

        val palaX = pala.x
        val palaY = pala.y

        val pajaX = paja.x
        val pajaY = paja.y

        val polloTechoX = polloTecho.x
        val polloTechoY = polloTecho.y

        val polloGraneroX = polloGranero.x
        val polloGraneroY = polloGranero.y

        val polloFrenteX = polloFrente.x
        val polloFrenteY = polloFrente.y

        val polloTroncoX = polloTronco.x
        val polloTroncoY = polloTronco.y

        val polloEscondidoX = polloEscondido.x
        val polloEscondidoY = polloEscondido.y

        val polloEspantaX = polloEspanta.x
        val polloEspantaY = polloEspanta.y

        val regaderaX = regadera.x
        val regaderaY = regadera.y

        val regaderaRojaX = regaderaRoja.x
        val regaderaRojaY = regaderaRoja.y

        val regaderaVaciaX = regaderaVacia.x
        val regaderaVaciaY = regaderaVacia.y

        val sacosX = sacos.x
        val sacosY = sacos.y

        val tridenteX = rastrillo.x
        val tridenteY = rastrillo.y

        val troncoX = tronco.x
        val troncoY = tronco.y
        //</editor-fold>

        //<editor-fold desc="Verificamos si el toque está dentro del objeto">

        if (x >= gallinaHuevosX && x <= gallinaHuevosX + gallinaHuevos.width
            && y >= gallinaHuevosY && y <= gallinaHuevosY + gallinaHuevos.height) {
            // El objeto ha sido encontrado
            gallinaHuevos.visibility = View.INVISIBLE
            gallinaHuevosCopia.visibility = View.INVISIBLE

            if (gallo.visibility == View.INVISIBLE){
                galloCopia.visibility == View.INVISIBLE
            } else {
                galloCopia.visibility = View.VISIBLE
            }
        }

        if (x >= galloX && x <= galloX + gallo.width
            && y >= galloY && y <= galloY + gallo.height
        ) {
            if (gallinaHuevosCopia.visibility == View.INVISIBLE){
                // El objeto ha sido encontrado
                gallo.visibility = View.INVISIBLE
                galloCopia.visibility = View.INVISIBLE
                finJuego()
            } else {
                mas.visibility = View.VISIBLE
                mas.postDelayed({mas.visibility = View.INVISIBLE}, 1000)
                counter = counter+2
                if (counter >= 60){
                    minutos++
                    counter = 0
                    tv_tiempo?.setText("" + minutos + ":0" + counter + "")
                } else {
                    if (counter < 10){
                        tv_tiempo?.setText("" + minutos + ":0" + counter + "")
                        counter++
                    } else {
                        tv_tiempo?.setText("" + minutos + ":" + counter + "")
                        counter++
                    }
                }
            }
        }

        if (x >= regaderaVaciaX && x <= regaderaVaciaX + regaderaVacia.width
            && y >= regaderaVaciaY && y <= regaderaVaciaY + regaderaVacia.height
        ) {
            // El objeto ha sido encontrado
            regaderaVacia.visibility = View.INVISIBLE
            regaderaVaciaCopia.visibility = View.INVISIBLE

            if (gallinaSaco.visibility == View.INVISIBLE){
                gallinaSacoCopia.visibility = View.INVISIBLE
            } else {
                gallinaSacoCopia.visibility = View.VISIBLE
            }
        }

        if (x >= gallinaSacoX && x <= gallinaSacoX + gallinaSaco.width
            && y >= gallinaSacoY && y <= gallinaSacoY + gallinaSaco.height
        ) {
            if (regaderaVaciaCopia.visibility == View.INVISIBLE){
                // El objeto ha sido encontrado
                gallinaSaco.visibility = View.INVISIBLE
                gallinaSacoCopia.visibility = View.INVISIBLE

                if (pala.visibility == View.INVISIBLE){
                    palaCopia.visibility == View.INVISIBLE
                } else {
                    palaCopia.visibility = View.VISIBLE
                }
            } else {
                mas.visibility = View.VISIBLE
                mas.postDelayed({mas.visibility = View.INVISIBLE}, 1000)
                counter = counter+2
                if (counter >= 60){
                    minutos++
                    counter = 0
                    tv_tiempo?.setText("" + minutos + ":0" + counter + "")
                } else {
                    if (counter < 10){
                        tv_tiempo?.setText("" + minutos + ":0" + counter + "")
                        counter++
                    } else {
                        tv_tiempo?.setText("" + minutos + ":" + counter + "")
                        counter++
                    }
                }
            }

        }

        if (x >= palaX && x <= palaX + pala.width
            && y >= palaY && y <= palaY + pala.height
        ) {
            if (gallinaSacoCopia.visibility == View.INVISIBLE && regaderaVaciaCopia.visibility == View.INVISIBLE){
                // El objeto ha sido encontrado
                pala.visibility = View.INVISIBLE
                palaCopia.visibility = View.INVISIBLE
                finJuego()
            } else {
                mas.visibility = View.VISIBLE
                mas.postDelayed({mas.visibility = View.INVISIBLE}, 1000)
                counter = counter+2
                if (counter >= 60){
                    minutos++
                    counter = 0
                    tv_tiempo?.setText("" + minutos + ":0" + counter + "")
                } else {
                    if (counter < 10){
                        tv_tiempo?.setText("" + minutos + ":0" + counter + "")
                        counter++
                    } else {
                        tv_tiempo?.setText("" + minutos + ":" + counter + "")
                        counter++
                    }
                }
            }

        }

        if (x >= tridenteX && x <= tridenteX + rastrillo.width
            && y >= tridenteY && y <= tridenteY + rastrillo.height
        ) {
            // El objeto ha sido encontrado
            rastrillo.visibility = View.INVISIBLE
            rastrilloCopia.visibility = View.INVISIBLE

            if (polloEscondido.visibility == View.INVISIBLE){
                polloEscondidoCopia.visibility == View.INVISIBLE
            } else {
                polloEscondidoCopia.visibility = View.VISIBLE
            }
        }

        if (x >= polloEscondidoX && x <= polloEscondidoX + polloEscondido.width
            && y >= polloEscondidoY && y <= polloEscondidoY + polloEscondido.height
        ) {
            if (rastrilloCopia.visibility == View.INVISIBLE){
                // El objeto ha sido encontrado
                polloEscondido.visibility = View.INVISIBLE
                polloEscondidoCopia.visibility = View.INVISIBLE
                finJuego()
            } else {
                mas.visibility = View.VISIBLE
                mas.postDelayed({mas.visibility = View.INVISIBLE}, 1000)
                counter = counter+2
                if (counter >= 60){
                    minutos++
                    counter = 0
                    tv_tiempo?.setText("" + minutos + ":0" + counter + "")
                } else {
                    if (counter < 10){
                        tv_tiempo?.setText("" + minutos + ":0" + counter + "")
                        counter++
                    } else {
                        tv_tiempo?.setText("" + minutos + ":" + counter + "")
                        counter++
                    }
                }
            }
        }

        if (x >= gallinaFrenteX && x <= gallinaFrenteX + gallinaFrente.width
            && y >= gallinaFrenteY && y <= gallinaFrenteY + gallinaFrente.height){
            // El objeto ha sido encontrado
            gallinaFrente.visibility = View.INVISIBLE
            gallinaFrenteCopia.visibility = View.INVISIBLE

            if (paja.visibility == View.INVISIBLE){
                pajaCopia.visibility == View.INVISIBLE
            } else {
                pajaCopia.visibility = View.VISIBLE
            }
        }

        if (x >= pajaX && x <= pajaX + paja.width
            && y >= pajaY && y <= pajaY + paja.height
        ) {
            if (gallinaFrenteCopia.visibility == View.INVISIBLE){
                // El objeto ha sido encontrado
                paja.visibility = View.INVISIBLE
                pajaCopia.visibility = View.INVISIBLE

                if (regadera.visibility == View.INVISIBLE){
                    regaderaCopia.visibility == View.INVISIBLE
                } else {
                    regaderaCopia.visibility = View.VISIBLE
                }

            } else {
                mas.visibility = View.VISIBLE
                mas.postDelayed({mas.visibility = View.INVISIBLE}, 1000)
                counter = counter+2
                if (counter >= 60){
                    minutos++
                    counter = 0
                    tv_tiempo?.setText("" + minutos + ":0" + counter + "")
                } else {
                    if (counter < 10){
                        tv_tiempo?.setText("" + minutos + ":0" + counter + "")
                        counter++
                    } else {
                        tv_tiempo?.setText("" + minutos + ":" + counter + "")
                        counter++
                    }
                }
            }
        }

        if (x >= regaderaX && x <= regaderaX + regadera.width
            && y >= regaderaY&& y <= regaderaY + regadera.height
        ) {
            if (pajaCopia.visibility == View.INVISIBLE && gallinaFrenteCopia.visibility == View.INVISIBLE){
                // El objeto ha sido encontrado
                regadera.visibility = View.INVISIBLE
                regaderaCopia.visibility = View.INVISIBLE
                finJuego()
            } else {
                mas.visibility = View.VISIBLE
                mas.postDelayed({mas.visibility = View.INVISIBLE}, 1000)
                counter = counter+2
                if (counter >= 60){
                    minutos++
                    counter = 0
                    tv_tiempo?.setText("" + minutos + ":0" + counter + "")
                } else {
                    if (counter < 10){
                        tv_tiempo?.setText("" + minutos + ":0" + counter + "")
                        counter++
                    } else {
                        tv_tiempo?.setText("" + minutos + ":" + counter + "")
                        counter++
                    }
                }
            }
        }

        if (x >= regaderaRojaX && x <= regaderaRojaX + regaderaRoja.width
            && y >= regaderaRojaY && y <= regaderaRojaY + regaderaRoja.height
        ) {
            // El objeto ha sido encontrado
            regaderaRoja.visibility = View.INVISIBLE
            regaderaRojaCopia.visibility = View.INVISIBLE
            polloFrenteCopia.visibility = View.VISIBLE
        }

        if (x >= polloFrenteX && x <= polloFrenteX + polloFrente.width
            && y >= polloFrenteY && y <= polloFrenteY + polloFrente.height
        ) {
            if (regaderaRojaCopia.visibility == View.INVISIBLE){
                // El objeto ha sido encontrado
                polloFrente.visibility = View.INVISIBLE
                polloFrenteCopia.visibility = View.INVISIBLE
                finJuego()
            } else {
                mas.visibility = View.VISIBLE
                mas.postDelayed({mas.visibility = View.INVISIBLE}, 1000)
                counter = counter+2
                if (counter >= 60){
                    minutos++
                    counter = 0
                    tv_tiempo?.setText("" + minutos + ":0" + counter + "")
                } else {
                    if (counter < 10){
                        tv_tiempo?.setText("" + minutos + ":0" + counter + "")
                        counter++
                    } else {
                        tv_tiempo?.setText("" + minutos + ":" + counter + "")
                        counter++
                    }
                }
            }
        }

        if (x >= gallinaHojaX && x <= gallinaHojaX + gallinaHoja.width
            && y >= gallinaHojaY && y <= gallinaHojaY + gallinaHoja.height
        ) {
            // El objeto ha sido encontrado
            //gallinaHoja.visibility = View.INVISIBLE
            mas.visibility = View.VISIBLE
            mas.postDelayed({mas.visibility = View.INVISIBLE}, 1000)
            counter = counter+2
            if (counter >= 60){
                minutos++
                counter = 0
                tv_tiempo?.setText("" + minutos + ":0" + counter + "")
            } else {
                if (counter < 10){
                    tv_tiempo?.setText("" + minutos + ":0" + counter + "")
                    counter++
                } else {
                    tv_tiempo?.setText("" + minutos + ":" + counter + "")
                    counter++
                }
            }
        }

        if (x >= gallinaSaludaX && x <= gallinaSaludaX + gallinaSaluda.width
            && y >= gallinaSaludaY && y <= gallinaSaludaY + gallinaSaluda.height
        ) {
            // El objeto ha sido encontrado
            //gallinaSaluda.visibility = View.INVISIBLE
            mas.visibility = View.VISIBLE
            mas.postDelayed({mas.visibility = View.INVISIBLE}, 1000)
            counter = counter+2
            if (counter >= 60){
                minutos++
                counter = 0
                tv_tiempo?.setText("" + minutos + ":0" + counter + "")
            } else {
                if (counter < 10){
                    tv_tiempo?.setText("" + minutos + ":0" + counter + "")
                    counter++
                } else {
                    tv_tiempo?.setText("" + minutos + ":" + counter + "")
                    counter++
                }
            }
        }

        if (x >= polloTechoX && x <= polloTechoX + polloTecho.width
            && y >= polloTechoY && y <= polloTechoY + polloTecho.height
        ) {
            // El objeto ha sido encontrado
            //polloTecho.visibility = View.INVISIBLE
            mas.visibility = View.VISIBLE
            mas.postDelayed({mas.visibility = View.INVISIBLE}, 1000)
            counter = counter+2
            if (counter >= 60){
                minutos++
                counter = 0
                tv_tiempo?.setText("" + minutos + ":0" + counter + "")
            } else {
                if (counter < 10){
                    tv_tiempo?.setText("" + minutos + ":0" + counter + "")
                    counter++
                } else {
                    tv_tiempo?.setText("" + minutos + ":" + counter + "")
                    counter++
                }
            }
        }

        if (x >= polloGraneroX && x <= polloGraneroX + polloGranero.width
            && y >= polloGraneroY && y <= polloGraneroY + polloGranero.height
        ) {
            // El objeto ha sido encontrado
            //polloGranero.visibility = View.INVISIBLE
            mas.visibility = View.VISIBLE
            mas.postDelayed({mas.visibility = View.INVISIBLE}, 1000)
            counter = counter+2
            if (counter >= 60){
                minutos++
                counter = 0
                tv_tiempo?.setText("" + minutos + ":0" + counter + "")
            } else {
                if (counter < 10){
                    tv_tiempo?.setText("" + minutos + ":0" + counter + "")
                    counter++
                } else {
                    tv_tiempo?.setText("" + minutos + ":" + counter + "")
                    counter++
                }
            }
        }

        if (x >= polloTroncoX && x <= polloTroncoX + polloTronco.width
            && y >= polloTroncoY && y <= polloTroncoY + polloTronco.height
        ) {
            // El objeto ha sido encontrado
            //polloTronco.visibility = View.INVISIBLE
            mas.visibility = View.VISIBLE
            mas.postDelayed({mas.visibility = View.INVISIBLE}, 1000)
            counter = counter+2
            if (counter >= 60){
                minutos++
                counter = 0
                tv_tiempo?.setText("" + minutos + ":0" + counter + "")
            } else {
                if (counter < 10){
                    tv_tiempo?.setText("" + minutos + ":0" + counter + "")
                    counter++
                } else {
                    tv_tiempo?.setText("" + minutos + ":" + counter + "")
                    counter++
                }
            }
        }

        if (x >= polloEspantaX && x <= polloEspantaX + polloEspanta.width
            && y >= polloEspantaY&& y <= polloEspantaY + polloEspanta.height
        ) {
            // El objeto ha sido encontrado
            //polloEspanta.visibility = View.INVISIBLE
            mas.visibility = View.VISIBLE
            mas.postDelayed({mas.visibility = View.INVISIBLE}, 1000)
            counter = counter+2
            if (counter >= 60){
                minutos++
                counter = 0
                tv_tiempo?.setText("" + minutos + ":0" + counter + "")
            } else {
                if (counter < 10){
                    tv_tiempo?.setText("" + minutos + ":0" + counter + "")
                    counter++
                } else {
                    tv_tiempo?.setText("" + minutos + ":" + counter + "")
                    counter++
                }
            }
        }

        if (x >= sacosX && x <= sacosX + sacos.width
            && y >= sacosY && y <= sacosY + sacos.height
        ) {}

        if (x >= troncoX && x <= troncoX + tronco.width
            && y >= troncoY && y <= troncoY + tronco.height
        ) {
            // El objeto ha sido encontrado
            //tronco.visibility = View.INVISIBLE
            mas.visibility = View.VISIBLE
            mas.postDelayed({mas.visibility = View.INVISIBLE}, 1000)
            counter = counter+2
            if (counter >= 60){
                minutos++
                counter = 0
                tv_tiempo?.setText("" + minutos + ":0" + counter + "")
            } else {
                if (counter < 10){
                    tv_tiempo?.setText("" + minutos + ":0" + counter + "")
                    counter++
                } else {
                    tv_tiempo?.setText("" + minutos + ":" + counter + "")
                    counter++
                }
            }
        }

        return super.onTouchEvent(event)
        //</editor-fold>
    }

    private fun finJuego() {
        if (gallinaHuevosCopia.visibility == View.INVISIBLE &&
            galloCopia.visibility == View.INVISIBLE && palaCopia.visibility == View.INVISIBLE &&
            polloEscondidoCopia.visibility == View.INVISIBLE &&
            regaderaCopia.visibility == View.INVISIBLE && polloFrenteCopia.visibility == View.INVISIBLE
            && regaderaVaciaCopia.visibility == View.INVISIBLE && gallinaSacoCopia.visibility == View.INVISIBLE
            && rastrilloCopia.visibility == View.INVISIBLE && gallinaFrenteCopia.visibility == View.INVISIBLE
            && pajaCopia.visibility == View.INVISIBLE && regaderaRojaCopia.visibility == View.INVISIBLE)
        {

            stopCounter()
            mostrarTiempo()

            Handler().postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            },8000)
        }
    }

    private fun mostrarTiempo(){

        tv_tiempo.visibility = View.INVISIBLE
        tv.visibility = View.INVISIBLE

        tv2.visibility = View.VISIBLE
        if (counter < 10){
            tv_tiempo2?.setText("" + minutos + ":0" + counter + "")
            tv_tiempo2.visibility = View.VISIBLE
        } else {
            tv_tiempo2?.setText("" + minutos + ":" + counter + "")
            tv_tiempo2.visibility = View.VISIBLE
        }

    }
}
