#pragma once

#include <string>
#include <array>
#include <charconv>

namespace BHW
{
    inline std::string to_string(const float& f)
    {
        std::array<char, 32> buffer;
        std::to_chars_result result = std::to_chars(buffer.data(), buffer.data() + buffer.size(), f);
        
        if (result.ec != std::errc()) return std::string();
        
        return std::string(buffer.data(), result.ptr - buffer.data());
    }
}