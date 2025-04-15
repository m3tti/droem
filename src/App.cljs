(ns App
  (:require
   ["react" :refer [useState]]
   ["react-native" :refer [Text View StyleSheet StatusBar Button]]))

(def initialState {:route :home})

(def styles (StyleSheet.create
             {:container {:flex 1
                          :backgroundColor "#2d2d2d"
                          :alignItems "center"
                          :justifyContent "center"}}))

(defn- with-state [stateProps component]
  (component stateProps))

(defn- TestView [{:keys [state setState]}]
  #jsx [View {:style styles.container}
        [Text {:style {:color "#ffffff"}} "Hello"]
        [Button {:onPress #(setState {:route :home})
                 :title "Home"}]
        [StatusBar {:style "auto"}]])

(defn- HomeView [{:keys [state setState]}]
  #jsx [View {:style styles.container}
        [Text {:style {:color "#ffffff"}} "Droem 2.0"]
        [Button {:onPress #(setState {:route :test})
                 :title "Test"}]
        [StatusBar {:style "auto"}]])

(defn- App []
  (let [[state setState] (useState initialState)]
    (with-state {:state state :setState setState}
      (case (:route state)
        :home HomeView
        :test TestView))))

(def default App)
