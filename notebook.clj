(ns notebook)
(require '[clojure.string :as str])

(defrecord Note [body tags date-created time-created location])

(def date-now (get (str/split (str (java.time.LocalDateTime/now)) #"T") 0))

(def time-of-day (get (str/split (str (java.time.LocalDateTime/now)) #"T") 1))

(def time-now (get (str/split time-of-day #"\.") 0))  ; remove milliseconds

(defn write-to-log [my-note] (spit "log.clj" (str (pr-str my-note) "\n\n") :append true))

(defn build-note [body-text tags location]
  (def this-note (->Note body-text tags (str date-now) (str time-now) location))
  (write-to-log this-note)
  (pr-str this-note)
  )

; (def my-note (build-note "Today cool things happened..." ["dagbog" "oktober"] "Lejligheden, DK"))



