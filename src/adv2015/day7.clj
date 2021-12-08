(ns adv2015.day7
  (:gen-class)
  (:require [clojure.string :as str]))

(def ops "maps names od commands to functions"
  {:AND  bit-and
   :OR  bit-or
   :NOT #(bit-and 16rFFFF (bit-not %))
   :LSHIFT  bit-shift-left
   :RSHIFT  bit-shift-right})

(def db "'wire' 'command' map, used as database"
  (atom {}))

(defn make-booklet 
  "from ...['d' [:AND 'x' 'y']]... to {... d [] ...}"
  [inp]
  (into {} inp)
  )

(defn find-current
  "recursively finds current in every wire it needs"
  [k]
  (let [value (@db k)]
    (cond
      (number? k) k
      (number? value) value
      (vector? value) (let [[command & args] value
                            result (apply (ops command) (map find-current args))]
                        (swap! db assoc k result)
                        result)
      (string? value) (let [result (find-current value)] 
                        (swap! db assoc k result)
                        result)
      :else (throw (Exception. (str  "Error in Find current key: " k)))      
      )))

(defn day-7-p-1 [s]
  (let [booklet (make-booklet s)]
    (reset! db booklet)
    (find-current "a")))

  (defn day-7-p-2 [s]
    (let [booklet (make-booklet s)]
      (reset! db booklet)
      (swap! db assoc "b" 956)
      (find-current "a")))

(defn str?num:str
  "If string is number return int, else return source string"
  [str]
  (if (every? #(Character/isDigit %) str)
    (Integer/parseInt str)
    str))

 (defn parse-line
   "'x AND y -> d' => ['d' [:AND 'x' 'y']]"
   [line]
   (let [vals (re-seq #"\w+" line)
         result-wire (last vals)
         rearrange-3 (fn [[a1 kw a2]] [(keyword kw) (str?num:str a1) (str?num:str a2)])]
     (cond
       (= 2 (count vals)) [result-wire (str?num:str (first vals))]
       (= 3 (count vals)) [result-wire [:NOT (second vals)]]
       :else [result-wire (rearrange-3 vals)])))

(defn get-answer [path-to-file]
  (let [s (map parse-line (str/split-lines (slurp path-to-file)))]
    (time (println "Answer for first part is: " (day-7-p-1 s)))
    (time (println "Answer for second part is: " (day-7-p-2 s)))))
