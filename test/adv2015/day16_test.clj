(ns adv2015.day16-test
  (:require [clojure.test :refer :all]
            [adv2015.day16 :refer :all]))
			
(deftest aunts
	(testing "parse wrong" 
		(is (= nil (parse-aunt "Sue 1: cars: 2, akitas: 3, goldfish: 0" ))))
	(testing "parse ok" 
		(is (= 24 (parse-aunt "Sue 24: cars: 2, akitas: 0, goldfish: 5" ))))
)
	
(deftest aunts-p2
	(testing "parse ok" 
		(is (= 103 (parse-aunt "Sue 103: cats: 8, akitas: 0, goldfish: 4" :fun MF-check-p2 ))))
	(testing "parse wrong" 
		(is (= nil (parse-aunt "Sue 24: cats: 7, akitas: 1, goldfish: 5"  :fun MF-check-p2 ))))
) 