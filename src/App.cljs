(ns App
  (:require
   [DreamDiary :as dd]
   ["react" :refer [useState]]
   ["react-native" :refer [Text View StyleSheet StatusBar Button]]
   ["@react-native-async-storage/async-storage" :as AsyncStorage]))

(defn ^:async load-data [setState key]
  (setState (js-await (AsyncStorage/getItem key))))

(defn ^:async save-data [key value]
  (js-await (AsyncStorage/setItem key value)))

(def initialState {:route :dd-index
                   :dream-diary []})

(def styles (StyleSheet.create
             {:container {:flex 1
                          :backgroundColor "#2d2d2d"
                          :alignItems "center"
                          :justifyContent "center"}}))

(defn- with-state [stateProps component]
  (component (merge stateProps
                    {:load-data #(load-data (:setState stateProps) %)
                     :save-data save-data})))

(defn- App []
  (let [[state setState] (useState initialState)]
    (with-state {:state state :updateState #(setState (merge state %))}
      (case (:route state)
        :dd-index dd/Index
        :dd-edit dd/Edit
        ddv/Index))))

(def default App)
