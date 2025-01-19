package nz.co.example.app.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

internal data class AppColors(
    val accent: Accent,
    val background: Background,
    val foreground: Foreground,
    val icon: Icon
)

internal interface Accent {
    val accentPrimary: Color
}

internal interface Background {
    val backgroundPrimary: Color
    val backgroundSecondary: Color
    val backgroundTertiary: Color
    val backgroundBottomNavigation: Color
}

internal interface Foreground {
    val foregroundPrimary: Color
    val foregroundSecondary: Color
    val foregroundTertiary: Color
    val foregroundSeparator: Color
    val foregroundOnPrimary: Color
}

internal interface Icon {
    val iconPrimary: Color
    val iconSecondary: Color
    val iconTertiary: Color
}

internal val LightColors = AppColors(
    accent = object : Accent {
        override val accentPrimary = Color(0xFF0000FF)
    },
    background = object : Background {
        override val backgroundPrimary = Color(0xFFF4F4F9)
        override val backgroundSecondary = Color(0xFFE7E7EC)
        override val backgroundTertiary = Color(0xFFFFFFFF)
        override val backgroundBottomNavigation = Color(0xFFFFFFFF)
    },
    foreground = object : Foreground {
        override val foregroundPrimary = Color(0xFF000000)
        override val foregroundSecondary = Color(0xFF666666)
        override val foregroundTertiary = Color(0xFFB3B3B3)
        override val foregroundSeparator = Color(0xFFF0F0F0)
        override val foregroundOnPrimary = Color(0xFFFFFFFF)

    },
    icon = object : Icon {
        override val iconPrimary = Color(0xFF000000)
        override val iconSecondary = Color(0xFFB3B3B3)
        override val iconTertiary = Color(0xFF0000FF)
    }
)

internal val DarkColors = AppColors(
    accent = object : Accent {
        override val accentPrimary = Color(0xFF9595FE)
    },
    background = object : Background {
        override val backgroundPrimary = Color(0xFF181819)
        override val backgroundSecondary = Color(0xFF2E2E2F)
        override val backgroundTertiary = Color(0xFF474747)
        override val backgroundBottomNavigation = Color(0xFF0F0F10)
    },
    foreground = object : Foreground {
        override val foregroundPrimary = Color(0xFFFFFFFF)
        override val foregroundSecondary = Color(0xFF8B8B8C)
        override val foregroundTertiary = Color(0xFF5D5D5E)
        override val foregroundSeparator = Color(0xFF474749)
        override val foregroundOnPrimary = Color(0xFF000000)

    },
    icon = object : Icon {
        override val iconPrimary = Color(0xFFFFFFFF)
        override val iconSecondary = Color(0xFFB3B3B3)
        override val iconTertiary = Color(0xFF9595FE)
    }
)

internal val LocalColors = staticCompositionLocalOf { LightColors }