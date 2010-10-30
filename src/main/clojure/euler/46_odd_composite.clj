(ns euler.46-odd-composite
  (:use clojure.contrib.lazy-seqs))

(def prime-set (set (take-while #(< % 1000000) primes)))

(def odd-composites (filter odd?
			    (filter #(not (contains? prime-set %))
				    (iterate inc 3))))

(defn prime-twice-sq? [num]
  (some #(contains? prime-set %)
	(map #(- num (* 2 % %))
	     (range 1 (Math/sqrt num)))))

(defn main []
  (first (drop-while prime-twice-sq? odd-composites)))

(println (time (main)))

;"Elapsed time: 51.554205 msecs"
;5777
