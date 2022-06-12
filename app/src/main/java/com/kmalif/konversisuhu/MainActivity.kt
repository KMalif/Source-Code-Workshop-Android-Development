package com.kmalif.konversisuhu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kmalif.konversisuhu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //untuk memanggil id dari setiap komponen tampilan
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ubahSuhu()
        ulangi()

    }

    fun ubahSuhu(){
        // Ketika tombol hitung ditekan maka akan menjalankan perintah dibawah
        binding.button.setOnClickListener {
            //variabel untuk menampung inputan
            val suhu = binding.inputSuhu.text.toString().toDouble()
            val asal = binding.inputAsal.text.toString()
            val tujuan = binding.inputTujuan.text.toString()
            var hasil : Double = 0.0

            //pengkondisian untuk menentukan rumus dan menghitung hasil suhu
            if (asal.equals("C",true) && tujuan.equals("K",true)){  //jika dari Celcius ke kelvin
                hasil = suhu + 273
                binding.textHasil.setText("$suhu $asal = $hasil $tujuan")
            }else if (asal.equals("R",true) && tujuan.equals("K",true)){  //jika dari Reamur ke kelvin
                hasil = 5/4 * suhu + 273
                binding.textHasil.setText("$suhu $asal = $hasil $tujuan")
            }else if (asal.equals("F",true) && tujuan.equals("K",true)){    //jika dari Fahrenheit ke kelvin
                hasil = 5/9 * (suhu - 32) + 273
                binding.textHasil.setText("$suhu $asal = $hasil $tujuan")
            }else if (asal.equals("K",true) && tujuan.equals("C",true)){  //jika Kelvin ke Celcius
                hasil = suhu - 273
                binding.textHasil.setText("$suhu $asal = $hasil $tujuan")
            }else if (asal.equals("K",true) && tujuan.equals("R",true)){  //jika Kelvin ke Reamur
                hasil = 4/5 * (suhu - 273)
                binding.textHasil.setText("$suhu $asal = $hasil $tujuan")
            }else if (asal.equals("K",true) && tujuan.equals("F",true)){  //jika Kelvin ke Fahrenheit
                hasil = 9/5 * (suhu - 273) + 32
                binding.textHasil.setText("$suhu $asal = $hasil $tujuan")
            }else{                                              //jika inputan salah
                Toast.makeText(this, "Maaf inputanmu salah coba lagi ", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun ulangi(){
        binding.ButtonUlang.setOnClickListener {
            // Agar inputan kosong kembali
            binding.inputSuhu.setText("")
            binding.inputAsal.setText("")
            binding.inputTujuan.setText("")
            binding.textHasil.setText("")
        }
    }

}