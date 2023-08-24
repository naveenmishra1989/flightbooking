package example.naveen.dto;

import lombok.*;

import java.util.Map;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private String street;
    private String city;
    private String state;
    private String zip;
}
