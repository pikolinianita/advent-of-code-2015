(ns adv2015.day12-test
  (:require [clojure.test :refer :all]
            [adv2015.day12 :refer :all])) 
			
(deftest test-p1
	(testing "add" 
		(is (= 6 (day-12-p-1 "[1,2,3]"  ))))
	(testing "zero" 
		(is (= 0 (day-12-p-1 "{\"a\":[-1,1]}"  ))))	
)

(deftest test-p2
	(testing "add" 
		(is (= 4 (day-12-p-2 "[1,red,3]"  ))))
	(testing "zero" 
		(is (= 4 (day-12-p-2 "[1,{c:red,b:2},3]"  ))))
)

(deftest remove-vectors-test
	(testing "d1" 
		(is (= "[1,n,3]" (remove-red-in-vectors "[1,red,3]"  ))))
	(testing "d2" 
		(is (= "[1,n,3]" (remove-red-in-vectors "[1,\"red\",3]"  ))))
	(testing "d4" 
		(is (= "[nx,1,3]" (remove-red-in-vectors "[red,1,3]"  ))))
	(testing "d5" 
		(is (= "[1,3,n]" (remove-red-in-vectors "[1,3,red]"  ))))
	(testing "d3" 
		(is (= "{e:orange,c:blue,a:160,g:green,b:190,d:red,f:186}" (remove-red-in-vectors "{e:orange,c:blue,a:160,g:green,b:190,d:red,f:186}"  ))))		
)

(deftest remove-objects-test
	(testing "f1" 
		(is (= "[1,viol,3]" (remove-objects-with-red "[1,viol,3]"  ))))
	(testing "f2" 
		(is (= "[1,,3]" (remove-objects-with-red "[1,{e:orange,c:blue,a:160,g:green,b:190,d:red,f:186},3]"  ))))	
	(testing "f3" 
		(is (= "[,3]" (remove-objects-with-red "[{e:orange,c:blue,a:160,g:green,b:190,d:red,f:186},3]"  ))))
    (testing "f4" 
		(is (= "[1,]" (remove-objects-with-red "[1,{e:orange,c:blue,a:160,g:green,b:190,d:red,f:186}]"  ))))		
	(testing "f5" 
		(is (= "[1,]" (remove-objects-with-red "[1,{z:{b:190},d:red,f:186}]"  ))))
	(testing "f6" 
		(is (= "[1,{b:190,z:,f:186}]" (remove-objects-with-red "[1,{b:190,z:{d:red},f:186}]"  ))))
	(testing "f7" 
		(is (= "[1,]" (remove-objects-with-red "[1,{b:190,d:red,z:{f:186}}]"  ))))
)

(deftest fing-opening-closing
	(testing "o1" 
		(is (= 0 (find-opening "{1,viol,3}" 5))))
	(testing "o2" 
		(is (= 1 (find-opening "{{1,viol,3}}" 5))))	
	(testing "o3" 
		(is (= 0 (find-opening "{{1},viol,3}" 5))))
	(testing "o4" 
		(is (= 0 (find-opening "{1,viol,{3}}" 5))))	
	
	(testing "c1" 
		(is (= 9 (find-closing "{1,viol,3}" 5))))
	(testing "c2" 
		(is (= 10 (find-closing "{{1,viol,3}}" 5))))	
	(testing "c3" 
		(is (= 11 (find-closing "{{1},viol,3}" 5))))
	(testing "c4" 
		(is (= 11 (find-closing "{1,viol,{3}}" 5))))	
)
