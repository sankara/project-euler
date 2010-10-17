(ns euler.47-consec-prime-factors
  (:use clojure.contrib.lazy-seqs))

(defn factorize [n]
  (let [possible-factors (take-while #(< % (/ n 2)) primes)]
    (filter #(zero? (mod n %)) possible-factors)))

(def factorize (memoize factorize))

(defn main [e]
  (loop [n 1 s 1 c 0]
    (if (= e c) s
	(let [n-fac (count (factorize n))]
	  (if (= e n-fac)
	    (recur (inc n) s (inc c))
	    (recur (inc n) (inc n) 0))))))

;(println (time (main 4)))
;"Elapsed time: 499241.560247 msecs"
;134043








  