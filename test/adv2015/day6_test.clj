(ns adv2015.day6-test
  (:require [clojure.test :refer :all]
            [adv2015.day6 :refer :all])) 
			
(deftest day6-p1 
	(testing "small board on"
		(is (= 9 (get (frequencies (flatten (lights-fun func-part1 ["turn on 1,1 through 3,3"] 10))) 1 ))))
	
	(testing "small board on and off"
		(let [result-map (frequencies (flatten (lights-fun func-part1 ["turn on 1,1 through 3,3" "turn off 2,2 through 4,4"] 10)))]
			(is (= 5 (get result-map 1 )))
			(is (= 95 (get result-map 0 )))))
	
	(testing "small board on and toggle"
		(let [result-map (frequencies (flatten (lights-fun func-part1 ["turn on 1,1 through 3,3" "toggle 2,2 through 4,4"] 10)))]
			(is (= 10 (get result-map 1 )))
			(is (= 90 (get result-map 0 )))))
)

(deftest day6-p2 
	(testing "small board on"
		(is (= 9 (get (frequencies (flatten (lights-fun func-part2 ["turn on 1,1 through 3,3"] 10))) 1 )))
		(is (= 9 (reduce + (flatten (lights-fun func-part2 ["turn on 1,1 through 3,3"] 10))))))
	(testing "small board on twice"
		(is (= 9 (get (frequencies (flatten (lights-fun func-part2 ["turn on 1,1 through 3,3" "turn on 1,1 through 3,3"] 10))) 2 )))
		(is (= 18 (reduce + (flatten (lights-fun func-part2 ["turn on 1,1 through 3,3" "turn on 1,1 through 3,3"] 10))))))	
	(testing "small board on off"
		(is (= 5 (get (frequencies (flatten (lights-fun func-part2 ["turn on 1,1 through 3,3" "turn off 2,2 through 4,4"] 10))) 1 )))
		(is (= 95 (get (frequencies (flatten (lights-fun func-part2 ["turn on 1,1 through 3,3" "turn off 2,2 through 4,4"] 10))) 0 ))))	
	(testing "small board on toggle"
		(is (= 5 (get (frequencies (flatten (lights-fun func-part2 ["turn on 1,1 through 3,3" "toggle 2,2 through 4,4"] 10))) 1 )))
		(is (= 5 (get (frequencies (flatten (lights-fun func-part2 ["turn on 1,1 through 3,3" "toggle 2,2 through 4,4"] 10))) 2 )))
		(is (= 86 (get (frequencies (flatten (lights-fun func-part2 ["turn on 1,1 through 3,3" "toggle 2,2 through 4,4"] 10))) 0 )))
		(is (= 27 (reduce + (flatten (lights-fun func-part2 ["turn on 1,1 through 3,3" "toggle 2,2 through 4,4"] 10)))))
		)	
			
)