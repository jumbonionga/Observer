# Observer
*[Referencia](https://www.youtube.com/watch?v=QiKrKNTdGGs)*
## Pasos
1. Definir una interfaz para el observador.
   1. Esta interfaz tendrá un método que será llamado cuando el sujeto cambie de estado.
   ```
   public interface Observer {
      void update(String message);
   }
   ```
2. Definir una interfaz para los sujetos.
   1. Esta interfaz incluye métodos para añadir y eliminar observadores, y un método para notificar a todos los observadores de un cambio.
   ```
   public interface Subject {
      void addObserver(Observer o);
      void removeObserver(Observer o);
      void notifyObservers();
   }
   ```
3. Implementar el sujeto.
   1. Aquí es donde se mantendrá una lista de observadores y se notificará a estos observadores cuando haya un cambio.
   ```
   import java.util.ArrayList;
   import java.util.List;

    public class NewsAgency implements Subject {
       private String news;
       private List<Observer> observers;

       public NewsAgency() {
           observers = new ArrayList<>();
       }

       public void setNews(String news) {
           this.news = news;
           notifyObservers();
       }

       @Override
       public void addObserver(Observer o) {
           observers.add(o);
       }

       @Override
       public void removeObserver(Observer o) {
           observers.remove(o);
       }

       @Override
       public void notifyObservers() {
           for (Observer observer : observers) {
               observer.update(news);
           }
       }
   }
   ```
4. Implementar el observador.
   1. Cualquier clase que implemente esta interfaz reaccionará de alguna manera al cambio de estado del sujeto.
   ```
   public class NewsReader implements Observer {
      private String latestNews;

      @Override
      public void update(String news) {
          latestNews = news;
          System.out.println("Últimas noticias: " + latestNews);
      }
   }
   ```
5. Usar el patrón Observer.
   1. Crear instancias de los observadores y el sujeto, y añadir los observadores al sujeto.
   ```
   public class Main {
      public static void main(String[] args) {
         NewsAgency agency = new NewsAgency();
         NewsReader reader1 = new NewsReader();
         NewsReader reader2 = new NewsReader();

         agency.addObserver(reader1);
         agency.addObserver(reader2);

         agency.setNews("Java lanza una nueva versión!");
      }
   }
   ```