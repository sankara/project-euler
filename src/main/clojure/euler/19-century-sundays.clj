(ns euler.19 (:import java.util.Calendar))

(defn getNumSunday [#^Calendar cal end]
    (loop [count 0]
        (if (>= (. cal get (Calendar/YEAR)) end) count
            (do (. cal add (Calendar/MONTH) 1)
                (recur (if (= 1 (. cal get (Calendar/DAY_OF_WEEK))) (inc count) count))))))

(def cal (Calendar/getInstance))

(do (. cal set (Calendar/YEAR) 1901)
    (. cal set (Calendar/MONTH) 0)
    (. cal set (Calendar/DATE) 1))

(println (time (getNumSunday cal 2001)))

;"Elapsed time: 75.0781 msecs"
;171
