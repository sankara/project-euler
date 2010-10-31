(ns euler.43-pandigital-substring
  (:use clojure.contrib.combinatorics))

(def perms (permutations '(\0 \1 \2 \3 \4 \5 \6 \7 \8 \9)))

(def divisors [0 2 3 5 7 11 13 17])

(defn prop? [s-perm]
  (let [s (apply str s-perm)]
    (every? zero?
	    (for [i (range 1 8)]
	      (let [sub-s (str (nth s i)
			       (nth s (inc i))
			       (nth s (+ i 2)))]
		(mod (Integer/parseInt sub-s) (nth divisors i)))))))

(defn main []
  (reduce + 
	  (map #(Long/parseLong (apply str %))
	       (filter prop? perms))))

(println (time (main)))

;"Elapsed time: 285621.326802 msecs"
;16695334890
