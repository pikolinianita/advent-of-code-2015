(ns adv2015.day5-test
  (:require [clojure.test :refer :all]
            [adv2015.day5 :refer :all]))
			
(deftest day5
	(testing "aaa"
		(is (= true (nice? "aaa"))))
	(testing "ugknbfddgicrmopn"
		(is (= true (nice? "ugknbfddgicrmopn"))))
	(testing "jchzalrnumimnmhp"
		(is (= false (nice? "jchzalrnumimnmhp"))))
	(testing "haegwjzuvuyypxyu"
		(is (= false (nice? "haegwjzuvuyypxyu"))))
	(testing "dvszwmarrgswjxmb"
		(is (= false (nice? "dvszwmarrgswjxmb"))))
	(testing "a few"
		(is (= 2 (day-5 nice? ["dvszwmarrgswjxmb" "aaa" "ugknbfddgicrmopn" "haegwjzuvuyypxyu"]))))
)	
	
(deftest day5-p2	
	(testing "qjhvhtzxzqqjkmpb"
		(is (= true (nice2? "qjhvhtzxzqqjkmpb"))))
	(testing "xxyxx"
		(is (= true (nice2? "xxyxx"))))
	(testing "uurcxstgmygtbstg"
		(is (= false (nice2? "uurcxstgmygtbstg"))))
	(testing "ieodomkazucvgmuy"
		(is (= false (nice2? "ieodomkazucvgmuy"))))
	(testing "a few"
		(is (= 2 (day-5 nice2? ["xxyxx" "uurcxstgmygtbstg" "qjhvhtzxzqqjkmpb"]))))
)

