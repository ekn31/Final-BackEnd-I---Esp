package com.dh.catalogservice.domain.model;

import java.util.List;

public record Season(Integer seasonNumber, List<chapters> chapters) {
}
