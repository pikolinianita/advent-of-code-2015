(ns adv2015.day7-test
 (:require [clojure.test :refer [deftest testing is]]
           [adv2015.day7 :as sut]
           [clojure.string :as str])) 

(def pure-input 
  "123 -> x
  456 -> y
  x AND y -> d
  x OR y -> e
  x LSHIFT 2 -> f
  y RSHIFT 2 -> g
  NOT x -> h
 NOT y -> i
  h -> kw ")

(def digested{"x" 123
              "y" 456
              "d" [:AND "x" "y"]
              "e" [:OR "x" "y"]
              "f" [:LSHIFT "x" 2]
              "g" [:RSHIFT "y" 2]
              "h" [:NOT "x"]
              "i" [:NOT "y"]
              "kw" "h"})

(deftest utils
  (testing "ops"
    (is (= 507 ((sut/ops :OR) 123 456)))
    (is (= 72 ((sut/ops :AND) 123 456)))
    (is (= 492 ((sut/ops :LSHIFT) 123 2)))
    (is (= 114  ((sut/ops :RSHIFT) 456 2)))
    (is (= 65079 ((sut/ops :NOT) 456)))
    (is (= 65412 ((sut/ops :NOT) 123))))
  (testing "parse"
    (is (= ["d" [:AND "x" "y"]] (sut/parse-line "x AND y -> d")))
    (is (= ["h" [:NOT "x"]] (sut/parse-line  "NOT x -> h")))
    (is (= ["x" 123] (sut/parse-line "123 -> x")))
    (is (= ["cy" [:AND 1 "cx"]] (sut/parse-line "1 AND cx -> cy")))
    (is (= ["jr" [:RSHIFT "jp" 3]] (sut/parse-line "jp RSHIFT 3 -> jr")))
    (is (= ["a" "lx"] (sut/parse-line "lx -> a"))))
  (testing " instructions"
    (is (= digested (sut/make-booklet (map sut/parse-line (str/split-lines pure-input)))))))

  (deftest hmm
    (testing "number"
      (reset! sut/db digested)
      (is (= 123 (sut/find-current "x")))
      (is (= 123 (@sut/db "x"))))
    (testing "R Szift"
      (reset! sut/db digested)
      (is (= 114 (sut/find-current "g")))
      (is (= 114 (@sut/db "g"))))
    (testing "And "
      (reset! sut/db digested)
      (is (= 72 (sut/find-current "d")))
      (is (= 72 (@sut/db "d"))))
    (testing "Kw "
      (reset! sut/db digested)
      (is (= 65412 (sut/find-current "kw")))
      (is (= 65412 (@sut/db "kw")))
      (reset! sut/db digested)     
      ))