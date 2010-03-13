(ns euler)

(defn str-rev [s]
  (apply str (reverse s)))

(defn rev [n]
  (bigint (str-rev (str n))))

(defn palin? [n]
  (let [s (str n)]
    (= s (str-rev s))))

(defn next-n [n]
  (+ n (rev n)))

(defn lychrel? [number]
  (loop [n number c 0]
    (cond
      (and
        (> c 0)
        (palin? n)) false
      (>= c 50) true
      :else (recur (next-n n) (inc c)))))

(defn main []
  (count (filter lychrel? (range 1 10000))))

(println (time (main)))

;"Elapsed time: 1389.168126 msecs"
;249
