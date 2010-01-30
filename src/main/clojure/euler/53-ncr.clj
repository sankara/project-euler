(defn fact! [n] (reduce * (range 1 (inc n))))

(defn ncr [n r]
    (/ (fact! n) (* (fact! r) (fact! (- n r)))))

(defn main [n]
    (count (filter #(> % 1000000)
        (for [i (range 1 n) j (range 1 n)]
            (ncr i j)))))

(println (time (main 101)))

;"Elapsed time: 1058.36598 msecs"
;4075
