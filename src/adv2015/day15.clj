(ns adv2015.day15
    (:require [clojure.pprint :as pp]
			  [clojure.string :as s]
			   [clojure.test :as tst])
	(:gen-class))

(def ingredients {
:Sprinkles {:capacity 2, :durability 0, :flavor -2, :texture 0, :calories 3}
:Butterscotch {:capacity 0, :durability 5, :flavor -3, :texture 0, :calories 3}
:Chocolate {:capacity 0, :durability 0, :flavor 5, :texture -1, :calories 8}
:Candy {:capacity 0, :durability -1, :flavor 0, :texture 5, :calories 8}
})

(defn calc [spr but cho can]
	{
	 :pre  [(= 100 (+ spr but cho can))]
     ;:post [(tst/is (string? %))]
	 }
	(let [ get-total (fn [ingr] (+  (* spr (ingr (:Sprinkles ingredients)))
									(* but (ingr (:Butterscotch ingredients)))
									(* cho (ingr (:Chocolate ingredients)))
									(* can (ingr (:Candy ingredients)))))
		   cap-tot (get-total :capacity)
		   dur-tot (get-total :durability)
		   fla-tot (get-total :flavor)
		   tex-tot (get-total :texture)]
	(* cap-tot dur-tot fla-tot tex-tot)
	)
)

(calc 25 25 25 25)