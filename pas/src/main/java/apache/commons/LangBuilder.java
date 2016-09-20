package apache.commons;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class LangBuilder {
    public static void main(String[] args) {
        System.out.println(new Zu("4", null));
    }

    private static class Zu {
        private String id;
        private Object value;

        private Zu(String id, Object value) {
            this.id = id;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Zu that = (Zu) o;

            return new EqualsBuilder()
                    .append(id, that.id)
                    .isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder()
                    .append(id)
                    .toHashCode();
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                    .append("id", id)
                    .append("value", value)
                    .toString();
        }
    }

}
