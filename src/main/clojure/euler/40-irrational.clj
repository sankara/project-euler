(ns euler.40)

(def atoi #(Character/digit % 10))

(defn ir-str []
    (apply str (range 1 300000)))

(defn main []
    (let [s (ir-str)]
        (reduce *
            (for [i (range 7)] (atoi (nth s (dec (Math/pow 10 i))))))))

(println (time (main)))

;"Elapsed time: 1513.445679 msecs"
;210
