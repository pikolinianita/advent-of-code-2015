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
	
	(testing "qjhvhtzxzqqjkmpb"
    (is (= true (nice2? "qjhvhtzxzqqjkmpb"))))
	(testing "xxyxx"
    (is (= true (nice2? "xxyxx"))))
	(testing "uurcxstgmygtbstg"
    (is (= false (nice2? "uurcxstgmygtbstg"))))
	(testing "ieodomkazucvgmuy"
    (is (= false (nice2? "ieodomkazucvgmuy"))))
)

