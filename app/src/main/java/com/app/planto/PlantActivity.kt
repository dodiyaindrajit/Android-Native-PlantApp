package com.app.planto

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.app.planto.databinding.ActicityPlantBinding


class PlantActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding:ActicityPlantBinding
    var flag = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActicityPlantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this,R.color.sky_green)

        binding.imgSliderIcon.setOnClickListener {
            startAnimation()
        }

        binding.imgLargePlant.setOnClickListener {
            reverseAnimation()
        }

        binding.imgPotColorLightSoil.setOnClickListener(this)
        binding.imgPotColorSoil.setOnClickListener(this)
        binding.imgPotColorLightGreen.setOnClickListener(this)
        binding.imgPotColorGreen.setOnClickListener(this)
        binding.imgPotColorRed.setOnClickListener(this)
        binding.imgPotColorMateSoil.setOnClickListener(this)
        binding.imgPotColorBlue.setOnClickListener(this)


        val bundle = intent.extras
        if (bundle != null) {

            val plantName = bundle.getString("plantName")
            val plantType = bundle.getString("plantType")
            val plantPrice = bundle.getString("plantPrice")
            val picture = bundle.getInt("plantImage")

            binding.txtViewplantName.text = plantName
            binding.txtViewPlantType.text = plantType
            binding.txtViewPrice.text = plantPrice
            binding.imgLargePlant.setImageResource(picture)
        }

    }

    private fun reverseAnimation() {
        val view = binding.constraintLargePlant
        val plantScanner = binding.containerPlantScanner
        val containerSunLight = binding.containerSunLight
        val containerFertilizer = binding.containerFertilizer
        val containerPlantDetail = binding.containerPlantDetail
        val containerWheel = binding.containerWheel

        view.animate()
            .translationX(0f)
            .translationY(0f)
            .setDuration(500)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    super.onAnimationEnd(animation)

                    binding.txtViewPriceName.visibility = View.VISIBLE
                    binding.txtViewPrice.visibility = View.VISIBLE
                    binding.txtViewSizeName.visibility = View.VISIBLE
                    binding.txtViewSize.visibility = View.VISIBLE
                    binding.imgViewCart.visibility = View.VISIBLE
                    binding.imgViewHeart.visibility = View.VISIBLE
                    binding.imgSliderIcon.visibility = View.VISIBLE
                }
            })

        plantScanner.animate()
            .translationY(0f)
            .setDuration(500)
            .start()

        containerSunLight.animate()
            .translationX(0f)
            .translationY(0f)
            .setDuration(500)
            .start()

        containerFertilizer.animate()
            .translationX(0f)
            .translationY(0f)
            .setDuration(500)
            .start()

        containerPlantDetail.animate()
            .translationY(0f)
            .setDuration(500)
            .start()



        containerWheel.animate()
            .translationX(0f)
            .setDuration(500)
            .start()

    }

    private fun startAnimation() {

        val view = binding.constraintLargePlant
        val plantScanner = binding.containerPlantScanner
        val containerSunLight = binding.containerSunLight
        val containerFertilizer = binding.containerFertilizer
        val containerPlantDetail = binding.containerPlantDetail
        val containerWheel = binding.containerWheel

        view.animate()
            .translationX(-350f)
            .translationY(40f)
            .setDuration(500)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationStart(animation: Animator?) {
                    super.onAnimationEnd(animation)

                    binding.txtViewPriceName.visibility = View.INVISIBLE
                    binding.txtViewPrice.visibility = View.INVISIBLE
                    binding.txtViewSizeName.visibility = View.INVISIBLE
                    binding.txtViewSize.visibility = View.INVISIBLE
                    binding.imgViewCart.visibility = View.INVISIBLE
                    binding.imgViewHeart.visibility = View.INVISIBLE
                    binding.imgSliderIcon.visibility = View.INVISIBLE
                }

            })

        plantScanner.animate()
            .translationY(350f)
            .setDuration(500)
            .start()

        containerSunLight.animate()
            .translationX(-230f)
            .translationY(120f)
            .setDuration(500)
            .start()

        containerFertilizer.animate()
            .translationX(-475f)
            .translationY(240f)
            .setDuration(500)
            .start()

        containerPlantDetail.animate()
            .translationY(240f)
            .setDuration(500)
            .start()



        containerWheel.animate()
            .translationX(-400f)
            .setDuration(500)
            .start()

    }

    override fun onClick(view: View?) {

        when(view?.id)
        {
            R.id.img_pot_color_light_soil -> {
                binding.imgBasePot.visibility = View.VISIBLE
                binding.imgBasePot.setImageResource(R.drawable.ic_pot_base1)
            }

            R.id.img_pot_color_soil -> {
                binding.imgBasePot.visibility = View.VISIBLE
                binding.imgBasePot.setImageResource(R.drawable.ic_pot_base2)
            }
            R.id.img_pot_color_light_green -> {
                binding.imgBasePot.visibility = View.VISIBLE
                binding.imgBasePot.setImageResource(R.drawable.ic_pot_base3)
            }
            R.id.img_pot_color_green -> {
                binding.imgBasePot.visibility = View.GONE
            }
            R.id.img_pot_color_red -> {
                binding.imgBasePot.visibility = View.VISIBLE
                binding.imgBasePot.setImageResource(R.drawable.ic_pot_base5)
            }
            R.id.img_pot_color_mate_soil -> {
                binding.imgBasePot.visibility = View.VISIBLE
                binding.imgBasePot.setImageResource(R.drawable.ic_pot_base6)
            }
            R.id.img_pot_color_blue -> {
                binding.imgBasePot.visibility = View.VISIBLE
                binding.imgBasePot.setImageResource(R.drawable.ic_pot_base7)
            }

        }
    }
}