(defn to-chars [s]
    (reverse (reverse (str s))))

(defn to-int [l]
    (if (empty? l) 1
        (Integer/parseInt (apply str l))))

(defn cancel-common [a b]
    (let [s1 (to-chars a) s1-set (set s1)
          s2 (to-chars b) s2-set (set s2)]
        [(filter #(not (contains? s2-set %)) s1)
         (filter #(not (contains? s1-set %)) s2)]))

(defn main []
    (filter (complement nil?)
        (for [i (range 11 100) j (range (inc i) 100)]
            (let [f (/ i j)
                  l (cancel-common i j) i1 (to-int (first l)) j1 (to-int (last l))]
                (if
                    (and
                        (not (= i i1))
                        (not (= 0 (mod j 10)))
                        (= f (/ i1 j1)))
                    (str i "/" j))))))

(println (time (main)))

;"Elapsed time: 1.658242 msecs"
;(16/64 19/95 26/65 49/98)

;user=> (* (/ 16 64) (/ 19 95) (/ 26 65) (/ 49 98))
;1/100
