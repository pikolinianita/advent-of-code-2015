(ns adv2015.day4
  (:gen-class))
  
  (def coder (java.security.MessageDigest/getInstance "MD5"))
  
	(defn helper [mes count]
	(let [byte-arr (.digest (java.security.MessageDigest/getInstance "MD5") (.getBytes (str mes count)))]
		(if (and 
				(= 0 (get byte-arr 0))
				(= 0 (get byte-arr 1))
				(> 15 (get byte-arr 2))
				(< 0 (get byte-arr 2)))
			count
			(recur mes (inc count)) 
	)))
	 
	(defn md5a [arg]
	
   (apply str (.digest (java.security.MessageDigest/getInstance "MD5") (.getBytes "pqrstuv1048970")))
   (helper arg 0)
   )
	

  (defn md5b [mes arr count]
   (let [byte-arr (.digest (java.security.MessageDigest/getInstance "MD5") (.getBytes (str mes count)))]
		(if (and 
				(= 0 (get byte-arr 0))
				(= 0 (get byte-arr 1))
				(= 0 (get byte-arr 2))
				)
			(do 
				(def new-res (conj arr count))
				(println (str count ": " (get byte-arr 0) " " (get byte-arr 1) " " (get byte-arr 2))))
			(def new-res arr))
		(if (< count 10000000 )	
		(recur mes new-res (inc count))
		new-res)
   ))