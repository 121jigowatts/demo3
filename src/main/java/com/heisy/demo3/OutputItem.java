package com.heisy.demo3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OutputItem {

    private String data;

    @Override
    public String toString() {
        return "data: " + data;
    }

}