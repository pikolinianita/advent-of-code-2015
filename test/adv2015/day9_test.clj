(ns adv2015.day9-test
 (:require [clojure.test :refer :all]
            [adv2015.day9 :refer :all])) 
			
			
(deftest test-extract 
	(testing "simple"
		(is (= [:Faerun :Norrath 129] (extract-data "Faerun to Norrath = 129")))	
	))
	
(deftest pivot
	(testing "start-seq"
		(is (= 6 (find-pivot [1 2 3 4 5 6 7 8]))))
	(testing "end-seq"
		(is (= nil (find-pivot [8 7 6 5 4 3 2 1]))))
	(testing "next"
		(is (= 5 (find-pivot [1 2 3 4 5 6 8 7]))))
	(testing "last"
		(is (= 0 (find-pivot [1 8 7 6 5 4 3 2]))))
	
)

(deftest next-place
	(testing "start-seq"
		(is (= 6 (find-place 6 [1 2 3 4 5 6 7 8]))))
	(testing "end-seq"
		(is (= nil (find-place 0 [2 3 1]))))
	(testing "next"
		(is (= 5 (find-place 5 [1 2 3 4 5 6 8 7]))))
	(testing "last"
		(is (= 0 (find-place 0 [1 8 7 6 5 4 3 2]))))
	(testing "last-3"
		(is (= 0 (find-place 0 [3 8 7 6 5 4 2 1]))))
)

(deftest next-perm
	(testing "start-seq"
		(is (= [1 2 3 4 5 6 8 7] (get-next-perm [1 2 3 4 5 6 7 8]))))
	(testing "end-seq"
		(is (= nil (get-next-perm [8 7 6 5 4 3 2 1]))))
	(testing "next"
		(is (= [1 2 3 4 5 7 6 8] (get-next-perm [1 2 3 4 5 6 8 7]))))
	(testing "last"
		(is (= [2 1 3 4 5 6 7 8] (get-next-perm [1 8 7 6 5 4 3 2]))))
	(testing "bug"
		(is (= [3 1 2] (get-next-perm [2 3 1]))))
	(testing "bug"
		(is (= [3 2 1] (get-next-perm [3 1 2]))))
	
)



;(deftest perms-count
;		(testing "3-seq"
;			(is ( = 6 (count (get-permutations [1 2 3])))))
;		(testing "4-seq"
;			(is ( = 24 (count (get-permutations [1 2 3 4])))))
;		(testing "5-seq"
;			(is ( = 120 (count (get-permutations [1 2 3 4])))))
;)

