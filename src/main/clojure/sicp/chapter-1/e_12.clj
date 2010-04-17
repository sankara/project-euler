(ns sicp.e-12)
(defn pascal 
  ([r]
     (for [i (range r)]
       (for [j (range (inc i))]
	 (pascal i j))))
  ([i j]
     (cond 
      (= j 0) 1
      (= i j) 1
      :else (+ (pascal (dec i) (dec j))
	       (pascal (dec i) j)))))
(pascal 4)
