(ns euler.15-path-grid)
(def grid-map (ref '{}))
(defn cache-solution [n m path-count]
    (do (dosync (alter grid-map conj {[n m] path-count})) path-count))

(defn path-grid [n m]
    (if (contains? @grid-map [n m])
        (get @grid-map [n m])
        (let [next-n (if (> n 0) (dec n) 0)
              next-m (if (> m 0) (dec m) 0)
              path-count (if (or (zero? n) (zero? m)) 1 (+ (path-grid n next-m) (path-grid next-n m)))]
            (cache-solution n m path-count))))

(println (time (path-grid 20 20)))

;"Elapsed time: 50.08158 msecs"
;137846528820
