package com.deep.app.jetpacknavigation

import java.io.Serializable

data class Animal(var name: String, var imgURL: String, var family: String) : Serializable {
    companion object {
        fun getData(animalFamily: String): MutableList<Animal> {
            val list = mutableListOf<Animal>()
            when (animalFamily) {
                "dogs" -> {
                    list.add(
                        Animal(
                            name = "Husky",
                            imgURL = "https://d17fnq9dkz9hgj.cloudfront.net/breed-uploads/2018/08/siberian-husky-card-small.jpg?bust=1535567860",
                            family = animalFamily
                        )
                    )
                    list.add(
                        Animal(
                            name = "German Shepherd",
                            imgURL = "https://upload.wikimedia.org/wikipedia/commons/a/a8/02.Owczarek_niemiecki_u%C5%BCytkowy_kr%C3%B3tkow%C5%82osy_suka.jpg",
                            family = animalFamily
                        )
                    )
                    list.add(
                        Animal(
                            name = "Shih Tzu",
                            imgURL = "https://s3.amazonaws.com/cdn-origin-etr.akc.org/wp-content/uploads/2017/11/12224329/Shih-Tzu-On-White-01.jpg",
                            family = animalFamily
                        )
                    )
                    list.add(
                        Animal(
                            name = "Golden retriever",
                            imgURL = "https://s3.amazonaws.com/cdn-origin-etr.akc.org/wp-content/uploads/2017/11/12121353/GoldenRetriever1_stacked.jpg",
                            family = animalFamily
                        )
                    )
                    list.add(
                        Animal(
                            name = "Rottweiler",
                            imgURL = "https://s3.amazonaws.com/cdn-origin-etr.akc.org/wp-content/uploads/2017/11/12224942/Rottweiler-On-White-10.jpg",
                            family = animalFamily
                        )
                    )
                    list.add(
                        Animal(
                            name = "Pitbull",
                            imgURL = "https://i0.wp.com/metro.co.uk/wp-content/uploads/2018/03/red-nose-pitbull-1-e1520600821708.jpg?quality=90&strip=all&zoom=1&resize=644%2C548&ssl=1",
                            family = animalFamily
                        )
                    )
                    list.add(
                        Animal(
                            name = "Chihuahua",
                            imgURL = "https://www.yourpurebredpuppy.com/dogbreeds/photos2-C/chihuahua-02.jpg",
                            family = animalFamily
                        )
                    )
                    list.add(
                        Animal(
                            name = "Labrador",
                            imgURL = "https://s3.amazonaws.com/cdn-origin-etr.akc.org/wp-content/uploads/2017/11/12231410/Labrador-Retriever-On-White-01.jpg",
                            family = animalFamily
                        )
                    )
                }
                "cats" -> {
                    list.add(
                        Animal(
                            name = "Siberian",
                            imgURL = "https://d17fnq9dkz9hgj.cloudfront.net/breed-uploads/2018/08/siberian-card-small.jpg?bust=1535569540",
                            family = animalFamily
                        )
                    )
                    list.add(
                        Animal(
                            name = "Tabby",
                            imgURL = "https://cdn0.wideopenpets.com/wp-content/uploads/2018/02/AdobeStock_109255057-770x405.jpg",
                            family = animalFamily
                        )
                    )
                    list.add(
                        Animal(
                            name = "Orange",
                            imgURL = "https://www.thehappycatsite.com/wp-content/uploads/2017/10/Orange-Tabby-Cat-Fascinating-Facts-About-Orange-Cats-HC-long.jpg",
                            family = animalFamily
                        )
                    )
                    list.add(
                        Animal(
                            name = "Calico",
                            imgURL = "https://www.thesprucepets.com/thmb/WCZZVbm3YgUncQO04dESh8bSMJI=/450x0/filters:no_upscale():max_bytes(150000):strip_icc()/12473529633_eca14113fe_k-5a932272303713003754f375.jpg",
                            family = animalFamily
                        )
                    )
                    list.add(
                        Animal(
                            name = "Persian",
                            imgURL = "https://d17fnq9dkz9hgj.cloudfront.net/breed-uploads/2018/08/persian-card-small.jpg?bust=1535569631",
                            family = animalFamily
                        )
                    )
                    list.add(
                        Animal(
                            name = "Siamese",
                            imgURL = "https://cdn0.wideopenpets.com/wp-content/uploads/2016/01/siamese-cat-cover.jpg",
                            family = animalFamily
                        )
                    )
                    list.add(
                        Animal(
                            name = "Hairless",
                            imgURL = "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/hairless-cat-breeds-sphynx-1567008601.jpg?crop=0.642xw:1.00xh;0.0952xw,0&resize=480:*",
                            family = animalFamily
                        )
                    )
                    list.add(
                        Animal(
                            name = "Bengal",
                            imgURL = "https://vetstreet-brightspot.s3.amazonaws.com/31/1ba400a28511e087a80050568d634f/file/Bengal-3-645mk062211.jpg",
                            family = animalFamily
                        )
                    )
                }
            }
            return list
        }
    }
}