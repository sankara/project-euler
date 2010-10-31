(ns euler.49-ap-prime
  (:use clojure.contrib.lazy-seqs))

(def prime-set (set (filter #(> % 1000)
			    (take-while #(< % 10000) primes))))

(defn prime? [n]
  (contains? prime-set n))

(defn perms? [num-seq]
  (apply = (map #(set (str %)) num-seq)))

(defn main []
  (filter
   (complement nil?)
   (for [prime-num prime-set
	 i (range prime-num (- 10000 (/ prime-num 2)))]
     (let [p-seq [prime-num (+ prime-num i) (+ prime-num i i)]]
       (if (and (every? prime? p-seq)
		(perms? p-seq))
	 p-seq)))))

(println (time (main)))
;"Elapsed time: 0.857831 msecs"
;([1487 4817 8147] [2969 6299 9629])

    



