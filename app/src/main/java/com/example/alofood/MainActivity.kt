package com.example.alofood

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alofood.databinding.ActivityMainBinding
import com.example.alofood.databinding.AlertRemoveBinding
import com.example.alofood.databinding.LayoutAlertBinding
import com.example.alofood.databinding.UpdateAlertBinding
import java.util.Random

class MainActivity : AppCompatActivity(), FoodAdapter.FoodEvents {
    lateinit var binding: ActivityMainBinding
    lateinit var myAdapter: FoodAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val FoodList = arrayListOf<Food>(
            Food(
                "Shole",
                "Mashhad",
                "30",
                "2.5",
                "https://irandoostan.com/dostcont/uploads/2016/06/rsz_shole_mashhad.jpg",
                10,
                2.5F
            ),
            Food(
                "Omlet",
                "Isfahan",
                "20",
                "9.6",
                "https://media.istockphoto.com/id/1254398596/photo/scrambled-eggs-with-spinach-and-tomato-in-pan-on-wooden-table-background.jpg?s=612x612&w=0&k=20&c=HuVq-YwbNq-UlVGl6xNNBuWHZHWNN4cH3zAjOj81-Y8=",
                3,
                3.5F
            ),
            Food(
                "Fesenjun",
                "Chabahar",
                "68",
                "3.2",
                "https://media.istockphoto.com/id/946208898/photo/chicken-fesenjan-pomegranate-walnut-stew-iranian-persian-cuisine.jpg?s=612x612&w=0&k=20&c=5XFpq9t9UsCU02j-LfHE-x6ZjagzzKZqs7zsimEMHU0=",
                9,
                5.7F
            ),
            Food(
                "Kelapch",
                "Tabriz",
                "5",
                "1.2",
                "https://media.istockphoto.com/id/1338649597/photo/eid-al-adha-food-delicatessen.jpg?s=612x612&w=0&k=20&c=iPfCFEyCdDsTWKEd-rTyQ5cR5Y0XyLIvRb2fWtzhsrI=",
                7,
                7.5F
            ),
            Food(
                "Morq",
                "Yasuj",
                "34",
                "10.6",
                "https://media.istockphoto.com/id/970873520/photo/roast-leg-of-lamb.jpg?s=612x612&w=0&k=20&c=erBj-S9q6-CBcOd0Tf5-ieTt--tUw4VHhdMbA1kfcyI=",
                4,
                1.5F
            ),
            Food(
                "Kubide",
                "Sanandaj",
                "74",
                "96.3",
                "https://media.istockphoto.com/id/501266025/photo/seekh-kabab-5.jpg?s=612x612&w=0&k=20&c=D6JXEtB4OLF9A91nAfDYLlh507LlbmP_M9PZBoJqD9Q=",
                0,
                3.7F
            ),
            Food(
                "Hamber",
                "Bojnord",
                "51",
                "4.3",
                "https://media.istockphoto.com/id/1254672762/photo/delicious-homemade-hamburger-and-french-fries.jpg?s=612x612&w=0&k=20&c=9BgdcWXRMb8hPZd2049StXFqvhDRq3izLkXK7Cq2C9s=",
                3,
                0.6F
            ),
            Food(
                "Pizza",
                "Birjand",
                "500",
                "9.7",
                "https://media.istockphoto.com/id/938742222/photo/cheesy-pepperoni-pizza.jpg?s=612x612&w=0&k=20&c=D1z4xPCs-qQIZyUqRcHrnsJSJy_YbUD9udOrXpilNpI=",
                4,
                4.7F
            ),
            Food(
                "AshReshteh",
                "Zahedan",
                "1000",
                "0.2",
                "https://media.istockphoto.com/id/953207712/photo/ash-reshteh-persian-noodle-soup.jpg?s=612x612&w=0&k=20&c=dgtp1Arwk7Rf0SGV4aCF1GhAKzfxq7brnuGMHFbPKSI=",
                6,
                1.1F
            ),
            Food(
                "Rice",
                "Ahvaz",
                "98",
                "4.1",
                "https://media.istockphoto.com/id/491090528/photo/cooked-rice.jpg?s=612x612&w=0&k=20&c=WNeDEUEioyyk6FQZQrVMrtFMDVdtbwtK951eZ8q5FNY=",
                8,
                3.3F
            ),
            Food(
                "Qeyme",
                "Behbahan",
                "10",
                "5.7",
                "https://media.istockphoto.com/id/1446972453/photo/khoresh-gheimeh-served-in-dish-isolated-on-grey-background-top-view-of-arabic-food.jpg?s=612x612&w=0&k=20&c=Th6JAv0y9gr68kR3y1NIIv4n1T5vdiUre45VYduPgqI=",
                7,
                8.8F
            ),
            Food(
                "Sushi",
                "Shiraz",
                "15",
                "8.1",
                "https://media.istockphoto.com/id/1176929581/photo/chopstick-holding-sushi-rolls-set-with-salmon-and-cream-cheese-and-cuccumber-on-black-slate.jpg?s=612x612&w=0&k=20&c=ctmjAzHzxnVSzvBruJt__oucuqn6g-V1Jadv-PRwLj8=",
                5,
                6.0F
            ),
            Food(
                "Dizi",
                "Sari",
                "47",
                "0.9",
                "https://media.istockphoto.com/id/1149683636/photo/abgoosht-traditional-persian-food.jpg?s=612x612&w=0&k=20&c=dLs8lEfQ3zTUm4P1oayKtc8BvJOsPPRXSlyDc1PjBoI=",
                3,
                9.8F
            ),
            Food(
                "QormeSabzi",
                "Ilam",
                "23",
                "22.2",
                "https://media.istockphoto.com/id/1155840436/photo/freshly-prepared-ghormeh-sabzi-of-lamb-stew-meat-with-herbs-and-beans-close-up-in-a-bowl-and.jpg?s=612x612&w=0&k=20&c=PpEOVOdWenHLMgmNZY9tBOJDWheYA-B2Es7ufasC5NQ=",
                2,
                1.1F
            ),
            Food(
                "Fries",
                "NewYork",
                "1",
                "200.3",
                "https://media.istockphoto.com/id/966934632/photo/appetizing-french-fries-in-a-bowl.jpg?s=612x612&w=0&k=20&c=6mKRNQ-PWQRQg0RAXyCQZeRZRoSzohqVWhT-SKVXd04=",
                1,
                6.7F
            ),

            )
        myAdapter = FoodAdapter(FoodList.clone() as ArrayList<Food>, this)
        binding.recyclerView.adapter = myAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        binding.itemAddMain.setOnClickListener {

            val dialog = AlertDialog.Builder(this).create()
            val dialogBinding = LayoutAlertBinding.inflate(layoutInflater)
            dialog.setView(dialogBinding.root)
            dialog.setCancelable(true)

            dialog.show()
            dialogBinding.itemBtnDone.setOnClickListener {
                if (
                    dialogBinding.itemEdtFoodName.length() > 0 &&
                    dialogBinding.itemEdtFoodCity.length() > 0 &&
                    dialogBinding.itemEdtFoodPrice.length() > 0 &&
                    dialogBinding.itemEdtFoodDistance.length() > 0
                ) {

                    val txtName = dialogBinding.itemEdtFoodName.text.toString()
                    val txtCity = dialogBinding.itemEdtFoodCity.text.toString()
                    val txtPrice = dialogBinding.itemEdtFoodPrice.text.toString()
                    val txtDistance = dialogBinding.itemEdtFoodDistance.text.toString()
                    val ratingNum: Int = (1..100).random()
                    val ratingStar: Float = (1..5).random().toFloat()
                    val randomUrlImg = (0 until 12).random()
                    val foodUrl = FoodList[randomUrlImg].urlImg
                    val newFood = Food(
                        txtName,
                        txtCity,
                        txtPrice,
                        txtDistance,
                        foodUrl,
                        ratingNum,
                        ratingStar
                    )
                    myAdapter.addFood(newFood)
                    binding.recyclerView.scrollToPosition(0)
                    dialog.dismiss()
                    //baraye adad Ashari az code zir estefade mikonim:
//                    val min = 0f
//                    val max = 5f
//                    val randoms :Float = min + Random().nextFloat() * (max - min)
                } else {
                    Toast.makeText(this, "Please Fill Fields :)", Toast.LENGTH_SHORT).show()
                }
            }


        }

        binding.edtSearch.addTextChangedListener { editTextInput ->

            if (editTextInput!!.isNotEmpty()) {

                val cloneList = FoodList.clone() as ArrayList<Food>
                val filterList = cloneList.filter { foodItem ->
                    (foodItem.txtSub.contains(editTextInput))

                }
                myAdapter.setData(ArrayList(filterList))


            } else {
                myAdapter.setData(FoodList.clone() as ArrayList<Food>)


            }
        }

    }

    override fun FoodClicked(food: Food, position: Int) {
        val dialog = AlertDialog.Builder(this).create()
        val dialogUpdateAlertBinding = UpdateAlertBinding.inflate(layoutInflater)
        dialog.setView(dialogUpdateAlertBinding.root)
        dialog.setCancelable(true)
        dialog.show()

        dialogUpdateAlertBinding.itemEdtFoodName.setText(food.txtSub)
        dialogUpdateAlertBinding.itemEdtFoodCity.setText(food.txtCity)
        dialogUpdateAlertBinding.itemEdtFoodPrice.setText(food.txtPrice)
        dialogUpdateAlertBinding.itemEdtFoodDistance.setText(food.txtDistance)
        dialogUpdateAlertBinding.updateCancel.setOnClickListener {
            dialog.dismiss()
        }
        dialogUpdateAlertBinding.updateDone.setOnClickListener {

            if (
                dialogUpdateAlertBinding.itemEdtFoodName.length() > 0 &&
                dialogUpdateAlertBinding.itemEdtFoodCity.length() > 0 &&
                dialogUpdateAlertBinding.itemEdtFoodPrice.length() > 0 &&
                dialogUpdateAlertBinding.itemEdtFoodDistance.length() > 0
            ) {

                val txtName = dialogUpdateAlertBinding.itemEdtFoodName.text.toString()
                val txtCity = dialogUpdateAlertBinding.itemEdtFoodCity.text.toString()
                val txtPrice = dialogUpdateAlertBinding.itemEdtFoodPrice.text.toString()
                val txtDistance = dialogUpdateAlertBinding.itemEdtFoodDistance.text.toString()

                val newFood = Food(
                    txtName,
                    txtCity,
                    txtPrice,
                    txtDistance,
                    food.urlImg,
                    food.numOfRating,
                    food.rating
                )
                myAdapter.updateFood(newFood, position)

                dialog.dismiss()

            } else {
                Toast.makeText(this, "Please fill the Fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun FoodLongClicked(oldFood: Food, oldPosition: Int) {

        val dialog = AlertDialog.Builder(this).create()
        val dialogDeleteBinding = AlertRemoveBinding.inflate(layoutInflater)
        dialog.setView(dialogDeleteBinding.root)
        dialog.setCancelable(true)
        dialog.show()

        dialogDeleteBinding.removeBtnCancel.setOnClickListener {

            dialog.dismiss()
        }
        dialogDeleteBinding.removeBtnSure.setOnClickListener {
            dialog.dismiss()
            myAdapter.removeFood(oldFood, oldPosition)
        }


    }
}

