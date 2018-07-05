import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Title {

    private String title, subtitle;
    private int fadeIn = 10, stay = 70, fadeOut = 20;

    private Title() {
        //private
    }

    private Title(Title title) {
        this.title = title.title;
        this.subtitle = title.subtitle;
        this.fadeIn = title.fadeIn;
        this.stay = title.stay;
        this.fadeOut = title.fadeOut;
    }

    public void sendTitleToAllPlayers() {
        for (final Player player : Bukkit.getServer().getOnlinePlayers()) {
            sendTitle(player);
        }
    }

    public void sendTitle(final Player player) {
        player.sendTitle(this.title, this.subtitle, this.fadeIn, this.stay, this.fadeOut);
    }

    public static Builder builder() {
        return new Title.Builder(new Title());
    }

    public static final class Builder {

        private final Title title;

        private Builder(Title title) {
            this.title = title;
        }

        /**
         * The main text of the title
         *
         * @param title title
         * @return this {@link Builder}
         */
        public Builder title(final String title) {
            this.title.title = title;
            return this;
        }

        /**
         * The secondary text of the title
         *
         * @param subtitle subtitle
         * @return this {@link Builder}
         */
        public Builder subtitle(final String subtitle) {
            this.title.subtitle = subtitle;
            return this;
        }

        /**
         * Время появления
         *
         * @param fadeIn время появления
         * @return this {@link Builder}
         */
        public Builder fadeIn(final int fadeIn) {
            this.title.fadeIn = fadeIn;
            return this;
        }

        /**
         * Время показа
         *
         * @param stay время показа
         * @return this {@link Builder}
         */
        public Builder stay(final int stay) {
            this.title.stay = stay;
            return this;
        }

        /**
         * время исчезновения
         *
         * @param fadeOut время исчезновения
         * @return this {@link Builder}
         */
        public Builder fadeOut(final int fadeOut) {
            this.title.fadeOut = fadeOut;
            return this;
        }


        /**
         * @return new {@link Title}
         */
        public Title build() {
            return new Title(this.title);
        }

    }

}
