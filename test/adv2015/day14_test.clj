(ns adv2015.day14-test
  (:require [clojure.test :refer :all]
            [adv2015.day14 :refer :all])
	(:import adv2015.day14.Renifer)) 
			
(def default-rudolph (Renifer. "Rudolf" 22 8 165))		
		
(deftest test-parser
	(testing "line" 
		(is (= default-rudolph (convert-line-to-renifer "Rudolf can fly 22 km/s for 8 seconds, but then must rest for 165 seconds."  ))))
	(testing "dist short"
		(is (= 22 (distance-in-time 1 default-rudolph  ))))
	(testing "dist cycle"
		(is (= 176 (distance-in-time 8 default-rudolph  ))))
	(testing "dist cycle +"
		(is (= 176 (distance-in-time 80 default-rudolph  ))))
	(testing "dist 2 cycle"
		(is (= 352 (distance-in-time 200 default-rudolph  ))))
	(testing "dist 1.5 cycle"
		(is (= 264 (distance-in-time 177 default-rudolph  ))))
)


