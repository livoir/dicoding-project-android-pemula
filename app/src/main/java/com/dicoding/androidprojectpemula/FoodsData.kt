package com.dicoding.androidprojectpemula

object FoodsData {
    private val foodNames = arrayOf("Rendang",
    "Ayam Pop",
    "Gurame Bakar",
    "Gurame Pesmol",
    "Cumi Asam Manis",
    "Ayam Bakar Kecap",
    "Keripik Balado",
    "Dendeng",
    "Es Teh Manis",
    "Jus Alpukat")

    private val foodDetails = arrayOf("Rendang adalah masakan yang kaya akan kandungan bumbu rempah. Selain bahan dasar daging, rendang menggunakan santan kelapa (karambia), dan campuran dari berbagai bumbu khas yang dihaluskan di antaranya cabai (lado), serai, lengkuas, kunyit, jahe, bawang putih, bawang merah dan aneka bumbu lainnya",
    "Ayam pop yang sudah diberi bumbu direbus terlebih dahulu di dalam rebusan air kelapa dan bawang putih cincang. Setelah itu, ayam baru digoreng sebentar di dalam minyak panas agar matang sempurna dan memperoleh sedikit tekstur renyah.\nBumbu yang digunakan adalah bawang putih, jahe, dan kemiri yang dihaluskan, kemudian ditumis bersama serai, garam, daun jeruk, atau perasan air jeruk nipis",
    "ikan direndam bumbu dengan campuran bumbu halus, kadang dengan campuran terasi atau kecap manis dan kemudian dipanggang.\nDibumbui dengan campuran kecap manis dan minyak kelapa atau margarin, dioleskan ke atas ikan dengan menggunakan kuas ketika pemanggangan menggunakan campuran bawang putih, bawang merah, cabai, ketumbar, air asam jawa, kemiri, kunyit, lengkuas dan garam",
    "Menu ikan gurame khas sunda dengan bumbu berbahan bawang merah, bawang putih, kunyir, cabai rawit, dan kemiri yang dihaluskan",
    "Cumi dengan bumbu asam manis",
    "Ayam bakar dengan racikan rempah dan kecap sebagai bumbu",
    "Camilan yang diolah dari singkong yang diiris tipis memanjang kemudian digoreng serta diberi garam dan bumbu balado ini begitu terkenal sebagai oleh-oleh khas Padang.",
    "Dendeng balado adalah masakan khas Sumatra Barat dibuat dari irisan tipis dan lebar daging sapi yang dikeringkan lalu digoreng kering. Daging goreng ini lalu diberi bumbu balado.",
    "Minuman yang terbuat dari larutan teh yang diberi pemanis seperti gula tebu, sebelum minuman ini siap disajikan.",
    "Jus alpukat merupakan salah satu minuman yang cukup populer di berbagai belahan dunia. Selain rasanya yang lezat dan menyegarkan, jus alpukat memiliki segudang manfaat bagi tubuh.")

    private val foodPrices = arrayOf(20000, 20000, 100000, 98000, 30000, 25000, 10000, 28000, 5000, 15000)

    private val foodCalories = arrayOf(468, 256, 1000, 1000, 225, 242, 150, 450, 200, 300)

    private val foodRatings = arrayOf(5.0, 4.7, 4.5, 4.6, 4.0, 4.3, 5.0, 3.8, 4.0, 4.1)


    private val foodImages = intArrayOf(R.drawable.rendang,
    R.drawable.ayam_pop,
    R.drawable.gurame_bakar,
    R.drawable.gurame_pesmol,
    R.drawable.cumi_asam_manis,
    R.drawable.ayam_bakar_kecap,
    R.drawable.keripik_balado,
    R.drawable.dendeng,
    R.drawable.es_teh_manis,
    R.drawable.jus_alpukat)

    val listData: ArrayList<Food>
        get() {
            val list = arrayListOf<Food>()
            for (position in foodNames.indices) {
                val food = Food()
                food.name = foodNames[position]
                food.detail = foodDetails[position]
                food.price = foodPrices[position]
                food.photo = foodImages[position]
                food.calorie = foodCalories[position]
                food.rating = foodRatings[position]
                list.add(food)
            }
            return list
        }

   fun getData(position: Int): Food {
       val food = Food()
       food.name = foodNames[position]
       food.detail = foodDetails[position]
       food.price = foodPrices[position]
       food.photo = foodImages[position]
       food.calorie = foodCalories[position]
       food.rating = foodRatings[position]

       return food
   }
}